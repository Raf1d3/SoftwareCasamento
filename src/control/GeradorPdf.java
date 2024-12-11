/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import model.InterfaceGenericDAO;

/**
 *
 * @author pse
 */
public class GeradorPdf {
    
    private static String caminho;

    public static void setCaminho(String caminho) {
        GeradorPdf.caminho = caminho;
    }

    public static String GerarPdf(List<InterfaceGenericDAO> lista, String nomeArquivo) {
        if (caminho == null || caminho.isEmpty()) {
            throw new IllegalArgumentException("O caminho para salvar o PDF não foi definido!");
        }
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(GeradorPdf.caminho + nomeArquivo + ".pdf"));
            documento.open(); 
            
            for (InterfaceGenericDAO item : lista) {
                List<Object> atributos = item.getValoresAtributos();

                StringBuilder conteudo = new StringBuilder();
                for (Object atributo : atributos) {
                    conteudo.append(atributo).append(" | ");
                }
                documento.add(new Paragraph(conteudo.toString()));
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao gerar o PDF: " + e.getMessage());
            return "";
        } finally {
            documento.close(); 
        }
        System.out.println("PDF gerado com sucesso em: " + GeradorPdf.caminho + nomeArquivo + ".pdf");
        return GeradorPdf.caminho + nomeArquivo + ".pdf";
    }
}
