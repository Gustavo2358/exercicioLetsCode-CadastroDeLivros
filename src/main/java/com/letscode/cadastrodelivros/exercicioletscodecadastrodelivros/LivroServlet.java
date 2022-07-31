package com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros;

import com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.bo.LivroBusinessObjectI;
import com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.model.Livro;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LivroServlet", value = "/livro-servlet/*")
public class LivroServlet extends HttpServlet {

    public LivroBusinessObjectI livroBusinessObjectI;

    @Inject
    public LivroServlet(LivroBusinessObjectI livroBusinessObjectI) {
        this.livroBusinessObjectI = livroBusinessObjectI;
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String caminho = request.getPathInfo();

        switch (caminho) {
            case "/cadastrar-livro":
                doPost(request, response);
                break;
            case "/carregar-para-edicao":
                carregarParaEdicao(request, response);
                break;
            case "/editar-livro":
                doPut(request, response);
                break;
            case "/deletar":
                doDelete(request, response);
                break;
            default:
                super.service(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String nome = request.getParameter("nome");
        String autor = request.getParameter("autor");

        Livro livro = new Livro(nome, autor);
        Livro livroSalvo = livroBusinessObjectI.save(livro);
        request.setAttribute("livroId", livroSalvo.getId());
        List<Livro> livros = livroBusinessObjectI.findAll();
        request.setAttribute("livros", livros);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-livros.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        livroBusinessObjectI.delete(Long.parseLong(request.getParameter("id")));

        List<Livro> livros = livroBusinessObjectI.findAll();
        request.setAttribute("livros", livros);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-livros.jsp");
        dispatcher.forward(request,response);


    }

    private void carregarParaEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idLivro = request.getParameter("id");

        Livro livro = livroBusinessObjectI.getById(idLivro);

        request.setAttribute("livro", livro);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/edicao-livro.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Livro livro = new Livro(request.getParameter("nome"), request.getParameter("autor"));
        livro.setId(Long.parseLong(id));
        Livro livroAlterado = livroBusinessObjectI.update(livro);
        request.setAttribute("idLivroAlterado", livroAlterado.getId());
        List<Livro> livros = livroBusinessObjectI.findAll();
        request.setAttribute("livros", livros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-livros.jsp");
        dispatcher.forward(request, response);

    }
}
