package dev.com.ismaelsilva;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Use Chromium
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();

            // Adicione o cabeçalho de autorização
            page.setExtraHTTPHeaders(Map.of("Cookie", "value"));

            // Navega para a página desejada
            page.navigate("https://www.litoralcar.com.br/");


            // Gera o PDF e salva no caminho especificado
            page.pdf(new Page.PdfOptions().setPath(Paths.get("example.pdf")));

            // Fecha o navegador
            browser.close();
        }
    }
}
