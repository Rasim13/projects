package TemplateMethod.example1;

public class WelcomePage extends WebsiteTemplate {

    @Override
    public void showPageContent() {
        System.out.println("Welcome");
    }
}
