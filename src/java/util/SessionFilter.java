/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/*"})
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
         HttpServletRequest req=(HttpServletRequest)sr;
         HttpServletResponse res=(HttpServletResponse)sr1;
         
         /*System.out.println("filter yolu"+req.getRequestURI());
         System.out.println("attribute"+req.getSession().getAttribute("username"));*/
         
         String sessionUser=(String)req.getSession().getAttribute("username");
         String currentPath=req.getRequestURI().toString();
         if(sessionUser!=null){
             if(currentPath.contains("petshop/index.jsf")){
                 res.sendRedirect(req.getContextPath()+"/template/admin.jsf");
             }else if(currentPath.contains("logout")){
                 req.getSession().invalidate();
                 res.sendRedirect(req.getContextPath()+"/index.jsf");
                     
             }else{
                 fc.doFilter(sr, sr1);
             }
         }else{
             if(currentPath.contains("template")){
                 res.sendRedirect(req.getContextPath()+"/admin.jsf");
             }else{
                  fc.doFilter(sr, sr1);
             }
             
         }
         
        
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
