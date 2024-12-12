/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import model.InterfaceGenericDAO;

/**
 *
 * @author pse
 */
public class GeradorPdf {

    private static String caminho = "/";

    public static void setCaminho(String caminho) {
        GeradorPdf.caminho = caminho;
    }

    public static String gerarPdf(String titulo, List<String> conteudo, String nomeArquivo) {
        if (caminho == null || caminho.isEmpty()) {
            throw new IllegalArgumentException("O caminho para salvar o PDF não foi definido!");
        }

        Document documento = new Document(PageSize.A4, 50, 50, 50, 50);
        try (OutputStream file = new FileOutputStream(new File(GeradorPdf.caminho + nomeArquivo + ".pdf"));) {
            PdfWriter.getInstance(documento, file);

            documento.open();

            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            Font subtituloFont = FontFactory.getFont(FontFactory.HELVETICA, 18);
            Font corpoFont = FontFactory.getFont(FontFactory.HELVETICA, 14);

            documento.add(new Paragraph(titulo, tituloFont));
            documento.add(new Paragraph("\n"));

            for (String linha : conteudo) {
                documento.add(new Paragraph(linha, corpoFont));
                documento.add(new Paragraph("\n"));
            }

            documento.add(new Paragraph("•••", subtituloFont));
            documento.add(new Paragraph("Relatório gerado pelo sistema de gerenciamento de casamentos: Entre Tapas e Beijos.", subtituloFont));

            documento.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao gerar o PDF: " + e.getMessage());
            return "";
        }

        System.out.println("PDF gerado com sucesso em: " + GeradorPdf.caminho + nomeArquivo + ".pdf");
        return GeradorPdf.caminho + nomeArquivo + ".pdf";
    }

    public static String gerarPdfIndividual(List<String> conteudo, int caso, String nomeArquivo) {
        if (caminho == null || caminho.isEmpty()) {
            throw new IllegalArgumentException("O caminho para salvar o PDF não foi definido!");
        }
        Document documento = new Document(PageSize.A4, 50, 50, 50, 50);
        try (OutputStream file = new FileOutputStream(new File(GeradorPdf.caminho + nomeArquivo + ".pdf"));) {

            PdfWriter.getInstance(documento, file);

            documento.open();

            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            Font subtituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font corpoFont = FontFactory.getFont(FontFactory.HELVETICA, 14);

            documento.add(new Paragraph("•••", tituloFont));
            documento.add(new Paragraph("Convite Especial", tituloFont));
            documento.add(new Paragraph("\n"));

            if (caso == 0) {
                documento.add(new Paragraph("Caro(a) " + conteudo.get(0), subtituloFont));
                documento.add(new Paragraph("É com grande alegria que convidamos você para compartilhar um momento único e inesquecível. Confira os detalhes de sua participação:", corpoFont));

                conteudo.set(0, "• Nome: " + conteudo.get(0));

                for (String linha : conteudo) {
                    documento.add(new Paragraph(linha, corpoFont));
                    documento.add(new Paragraph("\n"));
                }

                documento.add(new Paragraph("Contamos com sua presença para celebrar juntos esta ocasião especial!", corpoFont));
                documento.add(new Paragraph("Atenção: Guarde este convite com cuidado, pois ele será necessário para acessar o sistema do casamento e no dia do evento.", corpoFont));
            } else {

                documento.add(new Paragraph("Prezada Família " + conteudo.get(0), subtituloFont));
                documento.add(new Paragraph("É com grande alegria que convidamos vocês para celebrar um momento especial conosco. Este convite concede acesso exclusivo ao nosso evento e sistema, e pedimos que o guardem com carinho.", corpoFont));
                documento.add(new Paragraph("Detalhes do convite:", corpoFont));
                conteudo.set(0, "• Nome da Família: " + conteudo.get(0));

                for (String linha : conteudo) {
                    documento.add(new Paragraph(linha, corpoFont));
                    documento.add(new Paragraph("\n"));
                }

                documento.add(new Paragraph("Estamos ansiosos para compartilhar este dia memorável com todos vocês!", corpoFont));
                documento.add(new Paragraph("Atenção: para acessar o sistema e confirmar os convites dos convidados da familia entre com o nome da familia e senha fornecidos no convite.", corpoFont));

            }

            documento.add(new Paragraph("•••", tituloFont));
            documento.add(new Paragraph("Convite gerado pelo sistema de gerenciamento de casamentos: Entre Tapas e beijos.", corpoFont));

            documento.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao gerar o PDF: " + e.getMessage());
            return "";
        }

        System.out.println("PDF gerado com sucesso em: " + GeradorPdf.caminho + nomeArquivo + ".pdf");
        return GeradorPdf.caminho + nomeArquivo + ".pdf";
    }

}
