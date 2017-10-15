parser grammar TurtleParser;

options {
  language = Java;
  tokenVocab = TurtleLexer;
}

@header {
  package TP1;
}

document returns [ASD.Document out]
  : s=List<sujet> EOF { $out = new ASD.Document($s.out); }
  ;

sujet returns [ASD.Document.Sujet out]
	:	e=entite; lp=List<predicat> {$out = new ASD.Document.Sujet(e.$out, lp.$out);}
	;

predicat returns [ASD.Document.Predicat out]
	: e=entite; lo=List<objet> {$out = new ASD.Document.Predicat(e.$out, lo.$out);} 
	;

objet returns [ASD.Document.Objet out]
	:	ot=objetTexte {$out = new ASD.Document.Objet(ot.$out);}
	|	oe=objetEntite {$out = new ASD.Document.Objet(oe.$out);}
	;

objetTexte returns [ASD.Document.ObjetTexte out]
	:	t=texte {$out = new ASD.Document.ObjetTexte(t.$out);}
	;

objetEntite returns [ASD.Document.ObjetEntite out]
	:	e=entite {$out = new ASD.Document.ObjetEntite(e.$out);}	
	;

texte returns [ASD.Document.Texte out]
	: id=ident  {$out = new ASD.Document.Texte(id.$out);}
	;

entite returns [ASD.Document.Entite out]
	:	 id=ident {$out = new ASD.Document.Entite(id.$out);} 
	;

ident returns [String out]
	: ID {$out = $ID.text;}
	;
