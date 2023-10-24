package br.com.projectpd.infra.enums;

public enum MesFechamentoEnum {

	JANEIRO(1, "Janeiro"),
	FEVEREIRO(2,"Fevereiro"),
	MARÇO(3, "Março"),
	ABRIL(4, "Abril"),
	MAIO(5, "Maio"),
	JUNHO(6, "Junho"),
	JULHO(7, "Julho"),
	AGOSTO(8, "Agosto"),
	SETEMBRO(9, "Setembro"),
	OUTUBRO(10, "Outubro"),
	NOVEMBRO(11, "Novembro"),
	DEZEMBRO(12, "Dezembro");
	
	private Integer id;
	private String descricao;
	
	MesFechamentoEnum(Integer id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static MesFechamentoEnum findById(Integer id) {
		if(id != null) {
			for (MesFechamentoEnum t : MesFechamentoEnum.values()) {
			      if(t.getId().equals(id)) {
			    	  return t;
			      }
			  }
		}
		return null;
	}
}
