package br.com.projectpd.infra.enums;

public enum TituloEnum {
	
	MEMBRO(1,"Membro"), 
	LIDER(2,"Líder"), 
	OBREIRO(3,"Obreiro"), 
	DIACONO(4,"Diácono"), 
	MISSIONARIO(5,"Missionário"), 
	PASTOR(6,"Pastor"), 
	BISPO(7,"Bispo");
	
	private Integer id;
	private String descricao;
	
	TituloEnum(Integer id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public TituloEnum findById(Integer id) {
		if(id != null) {
			for (TituloEnum t : TituloEnum.values()) {
			      if(t.getId().equals(id)) {
			    	  return t;
			      }
			  }
		}
		return null;
	}

}
