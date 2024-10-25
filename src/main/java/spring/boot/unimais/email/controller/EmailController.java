package spring.boot.unimais.email.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.MessagingException;
import spring.boot.unimais.email.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendAtivacao")
    public ResponseEntity<String> sendAtivacaoEmail(
            @RequestParam String matriz,
            @RequestParam String destinatario,
            @RequestParam String emailAcesso,
            @RequestParam String senhaAcesso) {
        try {
            emailService.sendAtivacaoEmail(matriz, destinatario, emailAcesso, senhaAcesso);
            return ResponseEntity.ok("Email enviado com sucesso!");
        } catch (MessagingException e) {
            return ResponseEntity.status(500).body("Erro ao enviar email: " + e.getMessage());
        }
    }

    @PostMapping("/sendResetaSenha")
    public ResponseEntity<String> sendResetaSenha(
            @RequestParam String matriz,
            @RequestParam String destinatario,
            @RequestParam String emailAcesso,
            @RequestParam String senhaAcesso) {
        try {
            emailService.sendResetEmail(matriz, destinatario, emailAcesso, senhaAcesso);
            return ResponseEntity.ok("Email enviado com sucesso!");
        } catch (MessagingException e) {
            return ResponseEntity.status(500).body("Erro ao enviar email: " + e.getMessage());
        }
    }
}

