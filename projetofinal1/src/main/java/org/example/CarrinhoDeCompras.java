package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void removerItem(Produto produto) {
        itens.remove(produto);
    }

    public void listarItens() {
        for (Produto item : itens) {
            System.out.println(item.exibirDetalhes());
        }
    }

    public List<Produto> exportarListaProdutos() {
        return new ArrayList<>(itens);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void gerarArquivoTexto(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("item: Qtd: Nome: Preço: SubTotal:\n");
            int contador = 1;
            for (Produto item : itens) {
                double subtotal = item.getPreco() * item.getQuantidade();
                writer.write(contador + " " + item.getQuantidade() + " " + item.getNome() + " " + item.getPreco() + " " + subtotal + "\n");
                contador++;
            }
            writer.write("Total: " + calcularTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
