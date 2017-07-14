package banana.util.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {

  public final static String FROM_EMAIL = "hoang_van_tuan@mediado.jp";
  public final static String EMAIL_PASSWORD = "khf83957";
  public final static String EMAIL_HOST_NAME = "smtp.googlemail.com";
  public final static int SMTP_PORT = 465;

  HtmlEmail email = new HtmlEmail();

  public EmailUtil() {
    email.setHostName(EMAIL_HOST_NAME);
    email.setSmtpPort(SMTP_PORT);
    email.setAuthenticator(new DefaultAuthenticator(FROM_EMAIL, EMAIL_PASSWORD));
    email.setSSLOnConnect(true);
  }

  public void sendEmail(String to, String subject, String content) throws EmailException {
    email.setFrom(FROM_EMAIL);
    email.setSubject(subject);
    email.setHtmlMsg(content);
    email.addTo(to);
    email.send();
  }

  public void sendThankyouMail(String to) throws EmailException {
    String subject = "Thanks you for your register";
    String content = "Thank you " + to + "for your register /n Click<a href=\"localhost/banana/" + to + "\">Here</a> to login your home page";
    this.sendEmail(to, subject, content);
  }

  public void sendPasswordMail(String to, String password) throws EmailException {
    String subject = "Getback your password";
    String content = "Your password is " + password;
    this.sendEmail(to, subject, content);
  }
}
