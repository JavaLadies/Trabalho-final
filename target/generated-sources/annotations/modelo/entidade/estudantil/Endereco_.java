package modelo.entidade.estudantil;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SingularAttribute<Endereco, String> cidade;
	public static volatile SingularAttribute<Endereco, String> complemento;
	public static volatile SingularAttribute<Endereco, Escola> escola;
	public static volatile SingularAttribute<Endereco, Short> numero;
	public static volatile SingularAttribute<Endereco, String> nome;
	public static volatile SingularAttribute<Endereco, Long> id;
	public static volatile SingularAttribute<Endereco, Integer> cep;

	public static final String CIDADE = "cidade";
	public static final String COMPLEMENTO = "complemento";
	public static final String ESCOLA = "escola";
	public static final String NUMERO = "numero";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String CEP = "cep";

}

