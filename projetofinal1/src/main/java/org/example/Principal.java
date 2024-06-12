package org.example;

public class Principal {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho1 = new CarrinhoDeCompras();
        CarrinhoDeCompras carrinho2 = new CarrinhoDeCompras();

        Produto eletronico = new Eletronico("Smartphone", 2999.0, 24, 3);
        Produto roupa = new Roupa("T-Shirt", 89.99, "M", "Azul", 6);
        Produto alimento = new Alimento("Arroz", 9.99, "2024-12-31", 4);

        carrinho1.adicionarItem(eletronico);
        carrinho1.adicionarItem(roupa);
        carrinho1.adicionarItem(alimento);

        carrinho2.adicionarItem(new Eletronico("Laptop", 4999.0, 12, 1));
        carrinho2.adicionarItem(new Roupa("Calça Jeans", 199.99, "G", "Preta", 2));

        System.out.println("Carrinho 1:");
        carrinho1.listarItens();
        System.out.println("Total: " + carrinho1.calcularTotal());

        System.out.println("Carrinho 2:");
        carrinho2.listarItens();
        System.out.println("Total: " + carrinho2.calcularTotal());
        carrinho1.gerarArquivoTexto("carrinho1.txt");
        carrinho2.gerarArquivoTexto("carrinho2.txt");
    }
}

