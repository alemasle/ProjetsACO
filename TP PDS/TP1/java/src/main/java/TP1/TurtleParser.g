parser grammar TurtleParser;

options {
  language = Java;
  tokenVocab = TurtleLexer;
}

@header {
  package TP1;
}

document returns [ASD.Document out]
  :		s=sujet EOF {List<ASD.Document.Sujet> tl = new ArrayList<ASD.Document.Sujet>(); tl.add($s.out); $out = new ASD.Document(tl);}
  ;

sujet returns [ASD.Document.Sujet out]
	:	e=entite lp=predicat {List<ASD.Document.Predicat> pred = new ArrayList<ASD.Document.Predicat>(); pred.add($lp.out); $out = new ASD.Document.Sujet($e.out, pred);}
	;

predicat returns [ASD.Document.Predicat out]
	:	e=entite lo=objet {List<ASD.Document.Objet> lobj = new ArrayList<ASD.Document.Objet>(); lobj.add($lo.out); $out = new ASD.Document.Predicat($e.out, lobj);} 
	;

objet returns [ASD.Document.Objet out]
	:	ot=objetTexte {$out = $ot.out;}
	|	oe=objetEntite {$out = $oe.out;}
	;

objetTexte returns [ASD.Document.ObjetTexte out]
	:	t=texte {$out = new ASD.Document.ObjetTexte($t.out);}
	;

objetEntite returns [ASD.Document.ObjetEntite out]
	:	e=entite {$out = new ASD.Document.ObjetEntite($e.out);}	
	;

texte returns [ASD.Document.Texte out]
	: 	id=ident  {$out = new ASD.Document.Texte($id.out);}
	;

entite returns [ASD.Document.Entite out]
	:	 id=ident {$out = new ASD.Document.Entite($id.out);} 
	;

ident returns [String out]
	:	ID {$out = $ID.text;}
	;
