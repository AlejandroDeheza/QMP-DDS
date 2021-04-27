package ropa;

public enum TipoPrenda {

  REMERA(CategoriaPrenda.PARTE_SUPERIOR), BUZO(CategoriaPrenda.PARTE_SUPERIOR), CAMPERA(CategoriaPrenda.PARTE_SUPERIOR),
  ZAPATILLAS(CategoriaPrenda.CALZADO), ZAPATOS(CategoriaPrenda.CALZADO), BOTAS(CategoriaPrenda.CALZADO),
  MEDIAS(CategoriaPrenda.PARTE_INFERIOR), BERMUDA(CategoriaPrenda.PARTE_INFERIOR), PANTALON(CategoriaPrenda.PARTE_INFERIOR),
  LENTES(CategoriaPrenda.ACCESORIO);

  private CategoriaPrenda categoria;

  TipoPrenda(CategoriaPrenda categoria){
    this.categoria = categoria;
  }

  public CategoriaPrenda getCategoria(){
    return this.categoria;
  }
}
