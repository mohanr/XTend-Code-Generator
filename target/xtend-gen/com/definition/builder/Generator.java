package com.definition.builder;

import com.definition.builder.DefinitionBuilder;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Generator {
  private static String line;
  
  public CharSequence generateBody(final String name, final String body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* body of ");
    _builder.append(name);
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    _builder.append(body);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateMethod(final String name, final String body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void ");
    _builder.append(name);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateBody = this.generateBody(name, body);
    _builder.append(_generateBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public static void main(final String[] args) {
    final DefinitionBuilder definitionBuilder = new DefinitionBuilder();
    final DefinitionBuilder dataIterator = definitionBuilder.buildFileIterator();
    do {
      {
        Generator.line = dataIterator.next();
        InputOutput.<String>println((("File contents [" + Generator.line) + "]"));
      }
    } while((Generator.line != null));
    final Generator generator = new Generator();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return;");
    _builder.newLine();
    InputOutput.<CharSequence>println(
      generator.generateMethod("m", _builder.toString()));
  }
}
