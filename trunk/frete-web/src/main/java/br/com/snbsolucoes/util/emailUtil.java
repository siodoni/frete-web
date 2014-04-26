package br.com.snbsolucoes.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class emailUtil {
    
    public static void enviar(String emailRemetente, String nomeRemetente, final String usuario, final String senha, String smtpHost, String mailPort, String smtpAuth, String debug, Map<String, String> destinatario, Map<String, String> cc, Map<String, String> bcc, String assunto, String corpo, List<Anexo> anexo) throws MessagingException, UnsupportedEncodingException {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.port", mailPort);
        props.put("mail.smtp.auth", smtpAuth);
        props.put("mail.debug", debug);
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, senha);
            }
        };
        Session session = Session.getInstance(props, auth);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailRemetente, nomeRemetente));
        if (destinatario != null) {
            Set<String> keysDestinatario = destinatario.keySet();
            for (String key : keysDestinatario) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(key, destinatario.get(key)));
            }
            if (cc != null) {
                Set<String> keysCc = destinatario.keySet();
                for (String key : keysCc) {
                    message.addRecipient(Message.RecipientType.CC, new InternetAddress(key, cc.get(key)));
                }
            }
            if (bcc != null) {
                Set<String> keysBcc = bcc.keySet();
                for (String key : keysBcc) {
                    message.addRecipient(Message.RecipientType.BCC, new InternetAddress(key, bcc.get(key)));
                }
            }
        }
        message.setSubject(assunto, "UTF-8");
        Multipart mp = new MimeMultipart();
        MimeBodyPart mbpCorpo = new MimeBodyPart();
        mbpCorpo.setContent(corpo, "text/html");
        mp.addBodyPart(mbpCorpo);
        anexo = anexo == null ? new ArrayList<Anexo>() : anexo;
        for (Anexo ianexo : anexo) {
            MimeBodyPart mbp = new MimeBodyPart();
            if (ianexo.getFilePath() == null) {
                ByteArrayDataSource bds = new ByteArrayDataSource(ianexo.getBytes(), "application/octet-stream");
                mbp.setDataHandler(new DataHandler(bds));
                mbp.setFileName(ianexo.getFileName());               
            } else {
                FileDataSource fds = new FileDataSource(ianexo.getFilePath());
                mbp.setDataHandler(new DataHandler(fds));
                mbp.setFileName(fds.getName());
            }
            mp.addBodyPart(mbp);
        }
        message.setContent(mp);
        Transport.send(message);
    }
}
