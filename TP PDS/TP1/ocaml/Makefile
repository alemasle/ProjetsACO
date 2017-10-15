SRC=$(wildcard *.ml *.mll)

.PHONY: clean

main.native: $(SRC)
	ocamlbuild -pp camlp4o $@

clean:
	ocamlbuild -clean
