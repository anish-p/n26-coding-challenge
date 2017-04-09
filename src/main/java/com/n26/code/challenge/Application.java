package com.n26.code.challenge;

import com.n26.code.challenge.gateway.TransactionGateway;
import com.n26.code.challenge.gateway.transaction.inmemory.InmemoryTransactionGateway;
import com.n26.code.challenge.usecases.add.transaction.AddTransactionUseCase;
import com.n26.code.challenge.usecases.transaction.summary.TransactionSummaryUseCase;
import org.h2.server.web.WebServlet;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public TransactionGateway transactionGateway() {
        return new InmemoryTransactionGateway();
    }

    @Bean
    protected AddTransactionUseCase addTransactionUseCase() {
        AddTransactionUseCase addTransactionUseCase = new AddTransactionUseCase();
        addTransactionUseCase.setTransactionGateway(transactionGateway());
        return addTransactionUseCase;
    }

    @Bean
    protected TransactionSummaryUseCase transactionSummaryUseCase() {
        TransactionSummaryUseCase transactionSummaryUseCase = new TransactionSummaryUseCase();
        transactionSummaryUseCase.setTransactionGateway(transactionGateway());
        return transactionSummaryUseCase;
    }

    @Bean
    @Profile("default")
    protected ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        registrationBean.addInitParameter("webAllowOthers", "true");
        return registrationBean;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Profile("default")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9292");
    }
}
