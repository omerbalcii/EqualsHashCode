import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MainClass
{
	public static void main(String[] args)
	{
		 //ornek1();
		 //ornek2();
		 //ornek3();
	 ornek4();
	}

	private static void ornek4()
	{
		Person p1 = new Person("oğulcan");
		Person p2 = new Person("oğulcan");
		// ref ler karşılaştırılır
		System.err.println(p1 == p2);
		// içerikler karşılaştırılır
		System.err.println(p1.equals(p2));
	}

	private static void ornek3()
	{
		// hashmap 'te key olarak atayabilmek icin he equals hem hashcode metodu override edilmeli
		HashMap<Person, Vehicle> kisilerVeAraclar = new HashMap<>();
		Vehicle v1 = new Vehicle("audi");
		kisilerVeAraclar.put(new Person("Derya"), v1);//buraada derya ismi var 
		Vehicle v2 = new Vehicle("mercedes");
		kisilerVeAraclar.put(new Person("Derya"), v2);//new person yapsakta aynı isim verdiğimiz için aynı Person clasıdır
		System.err.println(kisilerVeAraclar);
	}

	private static void ornek2()
	{
//		add methoduna bakıyorum
//		add>hash>value bakıyoruz sonra bakıyoruz hashleri hashle eşitlemiş
//		bir yandanda equals karşılaştırmış
//		bu nesneden çıkarılacak olan hashcode isimle çıkarılsın
//		ömer ömer ikitane olursa  hashkodları aynı olur
//		isim aynıysa hashkod üret isim aynı olduğundan equals true olacak.

		Set<Person> kisiler = new HashSet<>();
//		System.err.println(new Person("sedanur"));
//		System.err.println(new Person("sedanur"));
		kisiler.add(new Person("sedanur"));
		kisiler.add(new Person("sedanur"));
		kisiler.add(new Person("sedanur"));
		kisiler.add(new Person("sedanur"));
		System.err.println(kisiler.contains(new Person("sedanur")));
		System.err.println(kisiler.toString());
	}

	private static void ornek1()
	{
//	person p=new Person("numan") böyle yapsam zaten true olacak 
//	conrtainsin yanına ekliyorum personi
//	cnontainsin içine giriyorum arıyorum bakıyorum equals istiyor
//	equalsda benim  hafızamdaki adreslerime bakıyor
//    new person yaptığımız için iki farklı personı karşılaştırmaya 
//	çalışıyor böyle olmaması için equalsi override etmem lazım
//	o nedenle arrayliste bunu yapmak zorunda kaldık hem contains
//	hem remove için bunlar object bekliyor parametre olarak
//	o objectin içindeki equals etmemi istiyor override etmezsek 
//    personların aynı olduğunu içeriğine bakarak anlayamıyor


		//
		ArrayList<Person> kisiler = new ArrayList<>();
		kisiler.add(new Person("numan"));
		
		System.err.println(kisiler.contains(new Person("numan")));
		System.err.println(kisiler.remove(new Person("numan")));
		// kisiler.stream().filter(p -> !p.getIsim().equals("numan")).forEach(p -> System.err.println(p));
		System.err.println(kisiler);
	}
}

class Vehicle
{
	private String name;

	public Vehicle(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Vehicle [name=" + name + "]";
	}

}

class Person
{
	private String isim;

	public String getIsim()
	{
		return isim;
	}

	public Person(String isim)
	{
		this.isim = isim;
	}

	@Override
	public String toString()
	{
		return "Person [isim=" + isim + "]";
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(isim);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(isim, other.isim);
	}
}

//record Person(String isim)
//{
//};