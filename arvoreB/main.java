package arvoreB;

public class main
{
	public main()
	{

	}

	public static void main(String[] args)
	{
		arvoreB arv = new arvoreB(1);

		Elemento e = new Elemento(1);
		Elemento e1 = new Elemento(2);
		Elemento e2 = new Elemento(3);
		Elemento e3 = new Elemento(4);
		Elemento e4 = new Elemento(5);
		Elemento e5 = new Elemento(6);

		arv.adicionaElemento(e3);
		arv.adicionaElemento(e1);
		arv.adicionaElemento(e2);
		arv.adicionaElemento(e3);
		arv.adicionaElemento(e5);

		System.out.println(arv.buscaElemento(2));
	}
}
