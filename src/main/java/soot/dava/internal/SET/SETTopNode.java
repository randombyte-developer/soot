/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Jerome Miecznikowski
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package soot.dava.internal.SET;

import soot.dava.internal.AST.ASTMethodNode;
import soot.dava.internal.AST.ASTNode;
import soot.dava.internal.asg.AugmentedStmt;
import soot.util.IterableSet;

public class SETTopNode extends SETNode {
  public SETTopNode(IterableSet body) {
    super(body);
    add_SubBody(body);
  }

  public IterableSet get_NaturalExits() {
    return new IterableSet();
  }

  public ASTNode emit_AST() {
    return new ASTMethodNode(emit_ASTBody(body2childChain.get(subBodies.get(0))));
  }

  public AugmentedStmt get_EntryStmt() {
    throw new RuntimeException("Not implemented.");
    // FIXME the following turned out to be ill-typed after applying type
    // inference for generics
    // body2childChain maps to IterableSet !
    // return (AugmentedStmt) ((SETNode) body2childChain.get(
    // subBodies.get(0))).get_EntryStmt();
  }

  protected boolean resolve(SETNode parent) {
    throw new RuntimeException("Attempting auto-nest a SETTopNode.");
  }
}
