package br.com.snbsolucoes.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mensagem{   

	private String detail;
	private String icon;
	private String summary;
	private String stackTrace;
	private static final Logger LOGGER = LoggerFactory.getLogger(Mensagem.class);
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	private static String stackTraceToString(Throwable throwable){
		try{
			Writer sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			throwable.printStackTrace(pw);
			return sw.toString();
		}catch(Exception ex){
			return "";
		}
	}

    private static void mensagem(Severity severity, String titulo, String mensagem) {
    	RequestContext.getCurrentInstance().update("form:msgInfoWarn");
    	RequestContext.getCurrentInstance().update("form:msgErrorFatal");
    	if(severity == FacesMessage.SEVERITY_ERROR || severity == FacesMessage.SEVERITY_FATAL || severity == FacesMessage.SEVERITY_WARN) {
            FacesContext.getCurrentInstance().validationFailed();
        }
        FacesMessage message = new FacesMessage(severity, titulo, mensagem);  
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private static void mensagem(Severity severity, String titulo, String mensagem, Throwable e) {
        //TODO Tratar os diferentes tipos de erro.(ORACLE)
    	RequestContext.getCurrentInstance().update("form:msgInfoWarn");
    	RequestContext.getCurrentInstance().update("form:msgErrorFatal");
        if(severity == FacesMessage.SEVERITY_ERROR || severity == FacesMessage.SEVERITY_FATAL) {
            mensagem = mensagem + "$#%" + stackTraceToString(e);
            FacesContext.getCurrentInstance().validationFailed();
        }
        if (severity == FacesMessage.SEVERITY_WARN) {
        	FacesContext.getCurrentInstance().validationFailed();
        }
        FacesMessage message = new FacesMessage(severity, titulo, mensagem);  
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public static void info(String mensagem) {
        mensagem(FacesMessage.SEVERITY_INFO, "Informativo", mensagem);
        LOGGER.info(mensagem);
    }

    public static void erro(String mensagem) {
        mensagem(FacesMessage.SEVERITY_ERROR, "Erro", mensagem);
        LOGGER.error(mensagem);
    }

    public static void fatal(String mensagem) {
        mensagem(FacesMessage.SEVERITY_FATAL, "Erro inesperado", mensagem);
        LOGGER.error(mensagem);
    }

    public static void warn(String mensagem) {
        mensagem(FacesMessage.SEVERITY_WARN, "Atenção", mensagem);
        LOGGER.warn(mensagem);
    }

    public static void info(String titulo, String mensagem) {
        mensagem(FacesMessage.SEVERITY_INFO, titulo, mensagem);
        LOGGER.info(titulo + " " + mensagem);
    }

    public static void erro(String titulo, String mensagem) {
        mensagem(FacesMessage.SEVERITY_ERROR, titulo, mensagem);
        LOGGER.error(titulo + " " + mensagem);
    }

    public static void fatal(String titulo, String mensagem) {
        mensagem(FacesMessage.SEVERITY_FATAL, titulo, mensagem);
        LOGGER.error(titulo + " " + mensagem);
    }

    public static void warn(String titulo, String mensagem) {
        mensagem(FacesMessage.SEVERITY_WARN, titulo, mensagem);
        LOGGER.warn(titulo + " " + mensagem);
    }

    public static void info(String titulo, String mensagem, Throwable e) {
        mensagem(FacesMessage.SEVERITY_INFO, titulo, mensagem, e);
        LOGGER.info(titulo + " " + mensagem, e);
    }

    public static void erro(String titulo, String mensagem, Throwable e) {
        mensagem(FacesMessage.SEVERITY_ERROR, titulo, mensagem, e);
        LOGGER.error(titulo + " " + mensagem, e);
    }

    public static void fatal(String titulo, String mensagem, Throwable e) {
        mensagem(FacesMessage.SEVERITY_FATAL, titulo, mensagem, e);
        LOGGER.error(titulo + " " + mensagem, e);
    }

    public static void warn(String titulo, String mensagem, Throwable e) {
        mensagem(FacesMessage.SEVERITY_WARN, titulo, mensagem, e);
        LOGGER.warn(titulo + " " + mensagem, e);
    }
}