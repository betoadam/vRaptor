package br.edu.utfpr.md.webapp.auth;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.edu.utfpr.md.webapp.AuthController;
import javax.inject.Inject;

@Intercepts
public class AuthenticationInterceptor {
    
    /* Condição de interceptação. É interceptado todo metodo
        que não possui a anotação @Public
    */
    @Inject private LoggedUser loggedUser;
    @Inject private Result result;
    
    @Accepts
    public boolean accepts(ControllerMethod method){
        return !method.containsAnnotation(Public.class);
    }
    
    @AroundCall
    public void intercept(SimpleInterceptorStack stack){
        // Obtendo o usuario authenticado na sessão
        
        if(!loggedUser.isLogged()){
            result.forwardTo(AuthController.class).login();
        }
                
        stack.next();
    }
}
