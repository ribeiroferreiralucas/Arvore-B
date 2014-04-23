package arvoreB;

import java.util.List;

public class arvoreB
{

	Pagina	raiz;

	int		ordem;

	public arvoreB(int ordem)
	{
		setOrdem(ordem);
		raiz = new Pagina(ordem);

	}

	public void implime()
	{

		raiz.imprime();
	}

	public Elemento buscaElemento(int e)
	{
		Elemento aux = raiz.buscaElemento(e);
		if (aux == null)
		{
			System.out.println("O Elemento não esta na arvore");
			return null;
		} else
		{
			return aux;
		}
	}

	public void adicionaElemento(Elemento e)
	{
		Elemento aux = raiz.adicionaElemento(e);
		if (aux != null)
		{
			Pagina pg = new Pagina(ordem);
			pg.adicionaElemento(aux);

			Pagina p1 = new Pagina(ordem);
			Pagina p2 = new Pagina(ordem);
			List<Elemento> j = raiz.getElementos().subList(0, ordem);
			List<Elemento> k = raiz.getElementos().subList(ordem,
					raiz.getElementos().size());

			p1.setElementos(j);
			p1.setFilhas(raiz.getFilhas().subList(0,
					raiz.getFilhas().size() / 2));
			p2.setElementos(k);
			p2.setFilhas(raiz.getFilhas().subList(raiz.getFilhas().size() / 2,
					raiz.getFilhas().size()));

			raiz = pg;
			raiz.getFilhas().add(p1);
			raiz.getFilhas().add(p2);

		}

	}

	public Pagina getRaiz()
	{
		return raiz;
	}

	public void setRaiz(Pagina raiz)
	{
		this.raiz = raiz;
	}

	public int getOrdem()
	{
		return ordem;
	}

	public void setOrdem(int ordem)
	{
		this.ordem = ordem;
	}

}
