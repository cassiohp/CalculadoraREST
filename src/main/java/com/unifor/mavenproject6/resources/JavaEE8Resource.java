package com.unifor.mavenproject6.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unifor.mavenproject6.model.Formula;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("javaee8")
public class JavaEE8Resource {      
    
    @GET    
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Path("somar/{dig1}/{dig2}")   
    public Response somar(@PathParam("dig1") String dig1, @PathParam("dig2") String dig2) {     
        int resultado = Integer.parseInt(dig1) + Integer.parseInt(dig2);
        if("Infinity".equals(String.valueOf(resultado))){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else{
            return Response.ok(resultado).build();
        }
    }
    
    @GET
    @Path("multiplicar/{dig1}/{dig2}")   
    public Response multiplicar(@PathParam("dig1") String dig1, @PathParam("dig2") String dig2) {     
        int resultado = Integer.parseInt(dig1) * Integer.parseInt(dig2);
        if("Infinity".equals(String.valueOf(resultado))){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else{
            return Response.ok(resultado).build();
        }
    }
    
    @GET
    @Path("subtrair/{dig1}/{dig2}")   
    public Response subtrair(@PathParam("dig1") String dig1, @PathParam("dig2") String dig2) {     
        int resultado = Integer.parseInt(dig1) - Integer.parseInt(dig2);
        if("Infinity".equals(String.valueOf(resultado))){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else{
            return Response.ok(resultado).build();
        }
    }
    
    @GET
    @Path("dividir/{dig1}/{dig2}")   
    public Response dividir(@PathParam("dig1") String dig1, @PathParam("dig2") String dig2) {     
        float resultado = Float.parseFloat(dig1) / Float.parseFloat(dig2);
        if("Infinity".equals(String.valueOf(resultado))){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            return Response.ok(resultado).build();
        }
    }
    
    @POST
    @Path("calcular")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response calcularPost(String expressao) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Formula formula = mapper.readValue(expressao, Formula.class);
            if(formula.getOperador() == '+'){
                int resultado = formula.getDig1() + formula.getDig2();
                return Response.ok(resultado).build();
            }else if(formula.getOperador() == '-'){
                int resultado = formula.getDig1() - formula.getDig2();
                return Response.ok(resultado).build();
            }else if(formula.getOperador() == '*'){
                int resultado = formula.getDig1() * formula.getDig2();
                return Response.ok(resultado).build();
            }else if(formula.getOperador() == '/'){
                float resultado = formula.getDig1() * formula.getDig2();
                if (formula.getDig2() == 0) {
                    return Response.status(Response.Status.BAD_REQUEST).build();
                }
                return Response.ok(resultado).build();
            }
            
        } catch (JsonProcessingException ex) {            
            return Response.serverError().build();
        }
       return Response.status(Response.Status.BAD_REQUEST).build();
    }
   
}
