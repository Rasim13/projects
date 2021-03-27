package TemplateMethod.example1;

public class NewsPage extends WebsiteTemplate {

    @Override
    public void showPageContent() {
        System.out.println("Welcome");
    }
}
