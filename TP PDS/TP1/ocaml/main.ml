open Lexer
open Parser
open ASD

let () =
  (* Use with a manually made AST *)
  let ast = …
  in print_endline (ASD.ntriples_of_ast ast)

  (* Use with lexer and parser *)
  (*
  let lexbuf = Lexing.from_channel stdin
  in try
    print_endline (ASD.ntriples_of_ast (Parser.parse (Stream.of_list (Lexer.tokenize lexbuf))))
  with Lexer.Unexpected_character e -> (
    Printf.printf "Unexpected character: `%c' at position '%d' on line '%d'\n"
      e.character e.pos e.line;
    exit 1
  )
  *)
