package spring.boot.unimais.email.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAtivacaoEmail(String matriz, String destinatario, String emailAcesso, String senhaAcesso) throws MessagingException {
        // Cria a mensagem de email
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // Configura remetente, destinatário e assunto
        helper.setFrom("suporte@portalunimais.com.br");
        helper.setTo(destinatario);
        helper.setSubject("Bem-vindo ao Portal Unimais! Acesse sua conta agora.");

        // Cria o corpo do email em HTML
        StringBuilder htmlBody = new StringBuilder();
        htmlBody.append("<p>Olá ").append(matriz).append("!</p>");
        htmlBody.append("<p>Parabéns! Sua loja foi cadastrada com sucesso em nosso sistema. Agora você já pode acessar o portal exclusivo para gerenciar seus pedidos e obter acesso a inúmeras oportunidades.</p>");
        htmlBody.append("<p>Aqui estão os seus dados de acesso:</p>");
        htmlBody.append("<p>Usuário: <strong>").append(emailAcesso).append("</strong><br>Senha: <strong>").append(senhaAcesso).append("</strong> (Por segurança, recomendamos que você altere sua senha no primeiro acesso).</p>");
        htmlBody.append("<p>Para acessar o portal, clique no link: <a href=\"http://negociosunimais.com.br\">http://negociosunimais.com.br</a></p>");
        htmlBody.append("<p>Atenciosamente,</p>");
        htmlBody.append("<p>A equipe Unimais</p>");

        // Define o conteúdo HTML do email
        helper.setText(htmlBody.toString(), true);

        // Envia o email
        mailSender.send(message);
    }


    public void sendResetEmail(String matriz, String destinatario, String emailAcesso, String senhaAcesso) throws MessagingException {
        // Cria a mensagem de email
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // Configura remetente, destinatário e assunto
        helper.setFrom("suporte@portalunimais.com.br");
        helper.setTo(destinatario);
        helper.setSubject("[SENHA ALTERADA] - Acesse sua conta agora.");

        // Cria o corpo do email em HTML
        StringBuilder htmlBody = new StringBuilder();
        htmlBody.append("<p>Olá ").append(matriz).append("!</p>");
        htmlBody.append("<p>Agora você já pode acessar o portal exclusivo para gerenciar seus pedidos e obter acesso a inúmeras oportunidades.</p>");
        htmlBody.append("<p>Aqui estão seus novos dados de acesso:</p>");
        htmlBody.append("<p>Usuário: <strong>").append(emailAcesso).append("</strong><br>Senha: <strong>").append(senhaAcesso).append("</strong> (Por segurança, recomendamos que você altere sua senha no primeiro acesso).</p>");
        htmlBody.append("<p>Para acessar o portal, clique no link: <a href=\"http://negociosunimais.com.br\">http://negociosunimais.com.br</a></p>");
        htmlBody.append("<p>Atenciosamente,</p>");
        htmlBody.append("<p>A equipe Unimais</p>");

        // Define o conteúdo HTML do email
        helper.setText(htmlBody.toString(), true);

        // Envia o email
        mailSender.send(message);
    }

    public void sendPedidoFornecedor(String fornecedor, String loja, String destinatario, long idPedido) throws MessagingException {
        // Cria a mensagem de email
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
    
        // Configura remetente, destinatário e assunto
        helper.setFrom("suporte@portalunimais.com.br");
        helper.setTo(destinatario);
        helper.setSubject("Novo pedido disponível no Portal Unimais!");
    
        // Cria o corpo do email em HTML
        StringBuilder htmlBody = new StringBuilder();
        htmlBody.append("<p>Olá ").append(fornecedor).append(",</p>");
        htmlBody.append("<p>A <strong>").append(loja).append("</strong> solicitou um novo pedido, e ele já está disponível para você!</p>");
        htmlBody.append("<p>Para visualizar os detalhes, clique no link abaixo:</p>");
        htmlBody.append("<p><a href=\"http://negociosunimais.com.br/pedidofornecedor/visualizar/")
                .append(idPedido)
                .append("\" style=\"color: #2a7ae2; text-decoration: none;\">Acessar Pedido</a></p>");
        htmlBody.append("<p>Se tiver qualquer dúvida, estamos à disposição para ajudar.</p>");
        htmlBody.append("<p>Atenciosamente,</p>");
        htmlBody.append("<p><strong>Equipe Unimais</strong></p>");
    
        // Define o conteúdo HTML do email
        helper.setText(htmlBody.toString(), true);
    
        // Envia o email
        mailSender.send(message);
    }    

}

