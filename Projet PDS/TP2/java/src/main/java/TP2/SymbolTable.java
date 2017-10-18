package TP2;

import java.util.Map;
import java.util.HashMap;

// This file contains the symbol table definition.
// A symbol table contains a set of ident and the
// corresponding symbols.
// It can have a parent, containing itself other
// symbols. If a symbol is not found, the request
// is forwarded to the parent.

public class SymbolTable {
  // Define different symbols
  public static abstract class Symbol {
    String ident; // minimum, used in the storage map
  }

  public static class VariableSymbol {
    ASD.Type type;
    String ident;

    VariableSymbol(ASD.Type type, String ident) {
      this.type = type;
      this.ident = ident;
    }
  }

  public static class FunctionSymbol {
    ASD.Type returnType;
    String ident;
    SymbolTable arguments; // Its argument can be viewed as a symbol table
    boolean defined; // false if declared but not defined
  }

  // Store the table as a map
  private Map<String, Symbol> table;
  // Parent table
  private SymbolTable parent;

  // Construct a new symbol table
  public SymbolTable() {
    table = new HashMap<String, Symbol>();
  }

  // Construct a new symbol table with a parent
  public SymbolTable(SymbolTable parent) {
    table = new HashMap<String, Symbol>();
    parent = parent;
  }

  // Add a new symbol
  // Returns false if the symbol cannot be added (already in the scope)
  public boolean add(Symbol sym) {
    Symbol res = table.get(sym.ident);
    if(res != null) {
      return false;
    }

    table.put(sym.ident, sym);
    return true;
  }

  // Remove a symbol
  // Returns false if the symbol is not in the table (without looking at parent's)
  public boolean remove(String ident) {
    return table.remove(ident) != null;
  }

  public Symbol lookup(String ident) {
    Symbol res = table.get(ident);

    if((res == null) && (parent != null)) {
      // Forward request
      return parent.lookup(ident);
    }

    return res; // Either the symbol or null
  }
}
