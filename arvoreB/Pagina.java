package arvoreB;

import java.util.ArrayList;
import java.util.List;

public class Pagina
{

	List<Elemento>	elementos;
	List<Pagina>	filhas;
	int				ordem;
	int				tamanhoMax;

	public Pagina(int ordem)
	{
		setOrdem(ordem);
		setTamanhoMax(ordem * 2);

		elementos = new ArrayList<Elemento>();
		filhas = new ArrayList<Pagina>();
	}

	public Elemento buscaElemento(int e)
	{
		int i = 0;

		System.out.println(elementos);
		for (Elemento elemento : elementos)
		{
			System.out.println(elemento + " " + e);
			if (elemento.getElemento() > e)
			{
				if (!filhas.isEmpty())
				{
					Elemento aux = filhas.get(i).buscaElemento(e);
					System.out.println(aux);
					if (aux != null)
					{
						return aux;
					} else
					{
						return null;
					}
				} else
				{
					return null;
				}

			} else if (elemento.getElemento() < e)
			{
				if (i == elementos.size() - 1)
				{
					if (!filhas.isEmpty())
					{
						Elemento aux = filhas.get(i + 1).buscaElemento(e);
						if (aux != null)
						{
							return aux;
						} else
						{
							return null;
						}
					} else
					{
						return null;
					}
				} else
				{
					i++;
					continue;
				}
			} else
			{
				return elemento;
			}
		}

		return null;
	}

	public Elemento adicionaElemento(Elemento e)
	{
		if (elementos.size() == 0)
		{
			elementos.add(e);
			return null;
		}

		int i = 0;
		for (Elemento elemento : elementos)
		{
			if (elemento.compareTo(e) < 0)
			{
				if (!filhas.isEmpty())
				{
					Elemento aux = filhas.get(i).adicionaElemento(e);
					if (aux != null)
					{
						elementos.add(i, aux);
						fazCisao(i);

						if (elementos.size() > tamanhoMax)
						{
							return elementos.remove(ordem);
						} else
						{
							break;
						}
					} else
					{
						break;
					}
				} else
				{
					elementos.add(i, e);
					if (elementos.size() > tamanhoMax)
					{
						return elementos.remove(ordem);
					} else
					{
						break;
					}
				}

			} else if (elemento.compareTo(e) > 0)
			{
				if (i == elementos.size() - 1)
				{

					if (!filhas.isEmpty())
					{
						Elemento aux = filhas.get(i + 1).adicionaElemento(e);
						if (aux != null)
						{
							elementos.add(aux);
							fazCisao(i + 1);

							if (elementos.size() > tamanhoMax)
							{
								return elementos.remove(ordem);
							} else
							{
								break;
							}
						} else
						{
							break;
						}
					} else
					{
						elementos.add(e);
						if (elementos.size() > tamanhoMax)
						{
							return elementos.remove(ordem);
						} else
						{
							break;
						}
					}
				} else
				{
					i++;
					continue;
				}
			} else
			{

				// Tem um igual. atualizo
				elementos.set(i, e);
				break;
			}
		}

		return null;
	}

	private void fazCisao(int i)
	{
		List<Elemento> e = filhas.get(i).getElementos();
		List<Pagina> p = filhas.get(i).getFilhas();
		filhas.remove(i);

		Pagina p1 = new Pagina(ordem);
		Pagina p2 = new Pagina(ordem);
		List<Elemento> j = e.subList(0, ordem);
		List<Elemento> k = e.subList(ordem, e.size());

		p1.setElementos(j);
		p1.setFilhas(p.subList(0, p.size() / 2));
		p2.setElementos(k);
		p2.setFilhas(p.subList(p.size() / 2, p.size()));

		filhas.add(i, p2);
		filhas.add(i, p1);

	}

	@Override
	public String toString()
	{
		return elementos.toString();
	}

	public void imprime()
	{
		System.out.println(elementos);

		for (Pagina pag : filhas)
		{
			pag.imprime();

		}
	}

	public List<Elemento> getElementos()
	{
		return elementos;
	}

	public void setElementos(List<Elemento> elementos)
	{
		this.elementos = elementos;
	}

	public List<Pagina> getFilhas()
	{
		return filhas;
	}

	public void setFilhas(List<Pagina> filhas)
	{
		this.filhas = filhas;
	}

	public int getOrdem()
	{
		return ordem;
	}

	public void setOrdem(int ordem)
	{
		this.ordem = ordem;
	}

	public int getTamanhoMax()
	{
		return tamanhoMax;
	}

	public void setTamanhoMax(int tamanhoMax)
	{
		this.tamanhoMax = tamanhoMax;
	}

}
