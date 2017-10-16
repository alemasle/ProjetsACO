parser grammar TurtleParser;

options {
  language = Java;
  tokenVocab = TurtleLexer;
}

@header {
  package TP1;
}

document returns [ASD.Document out]
  :		{List<ASD.Document.Sujet> tl = new ArrayList<ASD.Document.Sujet>();}
  		(s=sujet {tl.add($s.out);})* EOF 
  		{$out = new ASD.Document(tl);}
  ;

sujet returns [ASD.Document.Sujet out]
	:	{List<ASD.Document.Predicat> pred = new ArrayList<ASD.Document.Predicat>();}
		e=entite (lp=predicat {pred.add($lp.out);})* POINT
		{$out = new ASD.Document.Sujet($e.out, pred);}
	;

predicat returns [ASD.Document.Predicat out]
	:	{List<ASD.Document.Objet> lobj = new ArrayList<ASD.Document.Objet>();}
		e=entite (lo=objet {lobj.add($lo.out);})* PTVIRGULE?
		{$out = new ASD.Document.Predicat($e.out, lobj);} 
	;

objet returns [ASD.Document.Objet out]
	:	ot=objetTexte {$out = $ot.out;}	VIRGULE?
	|	oe=objetEntite {$out = $oe.out;}	VIRGULE?
	;

objetTexte returns [ASD.Document.ObjetTexte out]
	:	t=texte {$out = new ASD.Document.ObjetTexte($t.out);}
	;

objetEntite returns [ASD.Document.ObjetEntite out]
	:	e=entite {$out = new ASD.Document.ObjetEntite($e.out);}	
	;

texte returns [ASD.Document.Texte out]
	: 	GUILLEMET id=ident GUILLEMET {$out = new ASD.Document.Texte($id.out);}
	;

entite returns [ASD.Document.Entite out]
	:	CHVGAUCHE id=ident CHVDROITE {$out = new ASD.Document.Entite($id.out);} 
	;

ident returns [String out]
	:	ID {$out = $ID.text;}
	;
