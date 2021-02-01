//package callcenter.model;
//
//import java.io.IOException;
//import java.util.Properties;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//
///**
// *
// * @author mac
// */
//public class SendHTMLMail {
//    
//    public void sendMail() {
//        final String user = "";
//        final String pass = "";
//        
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.office365.com");
//        props.put("mail.smtp.port", "587");
//        
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(user, pass);
//                    }
//            });
//        
//        
//    }
//    
//    
//}
