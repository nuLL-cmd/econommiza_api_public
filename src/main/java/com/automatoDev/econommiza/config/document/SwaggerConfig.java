package com.automatoDev.econommiza.config.document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {


    @Value("${app.name}")
    private String nome;

    @Value("${app.version}")
    private String versao;

    @Value("${app.description}")
    private String descricao;

    @Value("${app.organization}")
    private String empresa;

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.automatoDev.econommiza.resource"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(informacoesApi())
        .useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET, mensagensGET())
        .globalResponseMessage(RequestMethod.POST, mensagensPOST())
        .globalResponseMessage(RequestMethod.PUT, mensagensPUT())
        .globalResponseMessage(RequestMethod.DELETE, mensagensDELETE());
    }


    private ApiInfo informacoesApi(){

        return new ApiInfo(
        nome,
        descricao,
        versao,
        empresa,
        new Contact("Desenvolvimento", " ","programadormoderador@hotmail.com"),
        " ",
        " ",
        Collections.emptyList());
    }

    private List<ResponseMessage> mensagensGET(){
        List<ResponseMessage> retornos = new ArrayList<>();
    
        retornos.add(new ResponseMessageBuilder()
        .code(200).message("Retorno da solicitaçaõ foi atendido (ok).").build());

        retornos.add(new ResponseMessageBuilder()
        .code(401).message("A solicitação não foi atendida, pois não foi aplicada as credenciais do usuario.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(403).message("O servidor atendeu a solicitação, mas se recusou a fornecer autorização.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(500).message("Erro interno do servidor.").build());

        return retornos;


    }

    private List<ResponseMessage> mensagensPUT(){
        List<ResponseMessage> retornos = new ArrayList<>();
    
        retornos.add(new ResponseMessageBuilder()
        .code(200).message("Retorno da solicitaçaõ foi atendido (ok).").build());

        retornos.add(new ResponseMessageBuilder()
        .code(401).message("A solicitação não foi atendida, pois não foi aplicada as credenciais do usuario.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(403).message("O servidor atendeu a solicitação, mas se recusou a fornecer autorização.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(500).message("Erro interno do servidor.").build());

        return retornos;


    }

    
    private List<ResponseMessage> mensagensPOST(){
        List<ResponseMessage> retornos = new ArrayList<>();
    
        retornos.add(new ResponseMessageBuilder()
        .code(201).message("O recurso foi criado e o resultado devolvido com sucesso.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(400).message("Possivlemente problemas de validação de campos, ou dados inválidos.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(401).message("A solicitação não foi atendida, pois não foi aplicada as credenciais do usuario.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(403).message("O servidor atendeu a solicitação, mas se recusou a fornecer autorização.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(500).message("Erro interno do servidor.").build());

        return retornos;


    }

        
    private List<ResponseMessage> mensagensDELETE(){
        List<ResponseMessage> retornos = new ArrayList<>();
    
        retornos.add(new ResponseMessageBuilder()
        .code(204).message("A situação foi atendida, porem não retornou nenhum dado.").build());
        
        retornos.add(new ResponseMessageBuilder()
        .code(401).message("A solicitação não foi atendida, pois não foi aplicada as credenciais do usuario.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(403).message("O servidor atendeu a solicitação, mas se recusou a fornecer autorização.").build());

        retornos.add(new ResponseMessageBuilder()
        .code(500).message("Erro interno do servidor.").build());

    
        return retornos;


    }

}
