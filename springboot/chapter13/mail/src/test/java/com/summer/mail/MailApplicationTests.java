package com.summer.mail;

import com.summer.mail.model.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.EngineContext;
import org.thymeleaf.context.IContext;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 发送简单的邮件
     *
     */
    @Test
    void contextLoads() {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("714990397@qq.com");
        simpleMessage.setTo("renp1993@gmail.com","821317512@qq.com");
        simpleMessage.setSentDate(new Date());
        simpleMessage.setSubject("测试主题-这里是测试主题");
        simpleMessage.setText("这是测试邮件的正文");
        javaMailSender.send(simpleMessage);

    }

    /**
     * 发送带有附件的邮件
     *
     * @throws MessagingException
     */
    @Test
    void test1() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("714990397@qq.com");
        mimeMessageHelper.setTo("821317512@qq.com");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setSubject("测试主题-这里是测试主题");
        mimeMessageHelper.setText("这是测试邮件的正文");
        File file = new File("E:/summer/springboot/code/chapter13/mail/src/main/resources/static/sea.jpg");
        mimeMessageHelper.addAttachment(file.getName(), file);
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送正文是html的邮件
     *
     * @throws MessagingException
     */
    @Test
    void test2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("714990397@qq.com");
        mimeMessageHelper.setTo("821317512@qq.com");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setSubject("测试主题-这里是测试主题");
        mimeMessageHelper.setText("<div>这是一封带有图片的邮件...</div><div><img src='cid:p01' /></div>", true);
        File file = new File("E:/summer/springboot/code/chapter13/mail/src/main/resources/static/sea.jpg");
        mimeMessageHelper.addInline("p01", file);
        javaMailSender.send(mimeMessage);
    }

    /**
     * 使用freemarker创建mail模板
     *
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     */
    @Test
    void test3() throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("714990397@qq.com");
        mimeMessageHelper.setTo("821317512@qq.com");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setSubject("测试主题-这里是测试主题");

        Configuration cnf = new Configuration(Configuration.VERSION_2_3_31);
        cnf.setClassLoaderForTemplateLoading(MailApplicationTests.class.getClassLoader(), "mail");
        Template template = cnf.getTemplate("mail.ftl");

        User user = new User();
        user.setUsername("summer");
        user.setCompany("sun公司");
        user.setPosition("资深架构师");
        user.setSalary(40000.0);

        StringWriter out = new StringWriter();
        template.process(user, out);
        mimeMessageHelper.setText(out.toString(), true);
        javaMailSender.send(mimeMessage);
    }

    @Autowired
    TemplateEngine templateEngine;
    @Test
    void test4() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("714990397@qq.com");
        mimeMessageHelper.setTo("821317512@qq.com");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setSubject("测试主题-这里是测试主题");

        Context context = new Context();
        context.setVariable("username", "summer");
        context.setVariable("company", "sun公司");
        context.setVariable("position", "资深架构师");
        context.setVariable("salary", 40000.0);
        String text = templateEngine.process("mail.html", context);
        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }


}
