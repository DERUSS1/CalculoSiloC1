package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import com.example.demo.layers.entities.Cliente;
import com.example.demo.layers.entities.Produto;
import com.example.demo.layers.repositories.ClienteRepository;
import com.example.demo.layers.repositories.ProdutoRepository;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	public ClienteRepository clienteRepository;

	@Test
	void testeInserirCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("João Cleiton");
		cliente.setCpf("123.456.111.70");
		cliente.setDataNascimento(LocalDate.of(1990, 1, 1));
		clienteRepository.save(cliente);
	}

	@Test
	void testeRemoverCliente(){
		clienteRepository.deleteById((long)1);
	}

	@Test
	void atualizarCliente(){
		Cliente cliente = clienteRepository.findById((long)1).get();
	}


    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void testeInserirProduto() {
        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setDescricao("Notebook Asus 3,0GHz 500GB SSD, 16GB RAM");

        produtoRepository.save(produto);
    }

	@Test
    void testeAtualizarProduto() {
        // Passo 1: Buscar o produto existente pelo ID
        Long id = 1L;  // ID do produto que queremos atualizar
        Produto produto = produtoRepository.findById(id).orElse(null);

        // Verificar se o produto foi encontrado
        if (produto != null) {
            // Passo 2: Modificar as propriedades do produto
            produto.setNome("Notebook Atualizado");
            produto.setDescricao("Notebook Asus 3,5GHz 1TB SSD, 32GB RAM");

            // Passo 3: Salvar o produto atualizado
            produtoRepository.save(produto);

            // Verificação: Buscar novamente para garantir que foi atualizado
            Produto produtoAtualizado = produtoRepository.findById(id).orElse(null);
            assert produtoAtualizado != null;
            assert produtoAtualizado.getNome().equals("Notebook Atualizado");
            assert produtoAtualizado.getDescricao().equals("Notebook Asus 3,5GHz 1TB SSD, 32GB RAM");
        } else {
            // Se o produto não for encontrado, falhe o teste
            assert false : "Produto não encontrado!";
        }
}

@Test
	void testeRemoverProduto(){
		produtoRepository.deleteById((long)5);
	}

	
}

