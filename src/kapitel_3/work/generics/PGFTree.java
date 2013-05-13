package kapitel_3.work.generics;

public class PGFTree<T> {
    Tree<PGFProxy> tree = null;
    
    private static final String pgfHeader = "\\begin{tikzpicture}\n" 
            + "    \\tikzset{\n"
            + "        every node/.style={\n" 
            + "            inner sep=0,\n"
            + "            outer sep=0,\n"
            + "            minimum width=12pt,\n"
            + "            minimum height=12pt,\n"
            + "            draw,\n"
            + "            top color=white,\n"
            + "            bottom color=yellow!20,\n"
            + "            font=\\scriptsize,\n" 
            + "            circle\n"
            + "        },\n" 
            + "        blank/.style={\n"
            + "            draw=none\n" 
            + "        },\n"
            + "        normal line/.style={\n"
            + "            draw=black,\n"
            + "        },\n"
            + "        normal node/.style={\n"
            + "            draw=black,\n"
            + "            solid,\n"
            + "            top color=white,\n"
            + "            bottom color=yellow!20,\n"
            + "        },\n" 
            + "        inserted node/.style={\n"
            + "            draw=red,\n"
            + "            top color=white,\n"
            + "            bottom color=red!20\n" 
            + "        },\n"
            + "        removed node/.style={\n" 
            + "            draw=blue,\n"
            + "            bottom color=blue!20,\n"
            + "            dash pattern=on 3pt off 3pt\n" 
            + "        },\n"
            + "        level distance=0.75cm,\n" 
            + "        level/.style={\n"
            + "            sibling distance=3cm/(2^(#1-1))\n" 
            + "        },\n"
            + "        edge from parent/.style={\n" 
            + "            draw,\n"
            + "            edge from parent path={\n"
            + "                (\\tikzparentnode) -- (\\tikzchildnode)\n"
            + "            }\n" 
            + "        },\n"
            + "    }\n";
    
    private String defaultSubTreeFormat = "";
    private String defaultNodeFormat = "";
    private String defaultChildrenFormat = "";
    private String defaultChildFormat = "";
    private String defaultEdgeFromParentFormat = "";
    
    public class PGFProxy {
        private String subTreeFormat = defaultSubTreeFormat;
        private String nodeFormat = defaultNodeFormat;
        private String childrenFormat = defaultChildrenFormat;
        private String childFormat = defaultChildFormat;
        private String edgeFromParentFormat = defaultEdgeFromParentFormat;

        protected T data = null;
        
        public PGFProxy(T data) {
            this.data = data;
        }
        
        public void setSubTreeFormat(String format) {
            subTreeFormat = format;
        }
        
        public void setNodeFormat(String format) {
            nodeFormat = format;
        }
        
        public void setChildrenFormat(String format) {
            childrenFormat = format;
        }
        
        public void setChildFormat(String format) {
            childFormat = format;
        }
        
        public void setEdgeFromParentFormat(String format) {
            edgeFromParentFormat = format;
        }
        
        public String subTreeFormat() {
            return subTreeFormat;
        }
        
        public String nodeFormat() {
            return nodeFormat;
        }
        
        public String childrenFormat() {
            return childrenFormat;
        }
        
        public String childFormat() {
            return childFormat;
        }
        
        public String edgeFromParentFormat() {
            return edgeFromParentFormat;
        }
        
        public String toString() {
            return data.toString();
        }
    }
    
    public String getDefaultSubTreeFormat() {
        return defaultSubTreeFormat;
    }

    public void setDefaultSubTreeFormat(String format) {
        defaultSubTreeFormat = format;
    }

    public String getDefaultNodeFormat() {
        return defaultNodeFormat;
    }

    public void setDefaultNodeFormat(String format) {
        defaultNodeFormat = format;
    }

    public String getDefaultChildrenFormat() {
        return defaultChildrenFormat;
    }

    public void setDefaultChildrenFormat(String format) {
        defaultChildrenFormat = format;
    }

    public String getDefaultChildFormat() {
        return defaultChildFormat;
    }

    public void setDefaultChildFormat(String format) {
        defaultChildFormat = format;
    }
    
    public String getDefaultEdgeFromParentFormat() {
        return defaultEdgeFromParentFormat;
    }
    
    public void setDefaultEdgeFromParentFormat(String format) {
        defaultEdgeFromParentFormat = format;
    }
    
    public static <T> void setSubTreeFormat(PGFTree<T>.PGFProxy pgfProxy, String format) {
        pgfProxy.setSubTreeFormat(format);
    }
    
    public static <T> void setNodeFormat(PGFTree<T>.PGFProxy pgfProxy, String format) {
        pgfProxy.setNodeFormat(format);
    }
    
    public static <T> void setChildrenFormat(PGFTree<T>.PGFProxy pgfProxy, String format) {
        pgfProxy.setChildrenFormat(format);
    }
    
    public static <T> void setChildFormat(PGFTree<T>.PGFProxy pgfProxy, String format) {
        pgfProxy.setChildFormat(format);
    }
    
    public static <T> void setEdgeFromParentFormat(PGFTree<T>.PGFProxy pgfProxy, String format) {
        pgfProxy.setEdgeFromParentFormat(format);
    }
     
    private static class PGFComparator<T> implements IComparator<PGFTree<T>.PGFProxy> {
        IComparator<T> comparator = null;
        
        public PGFComparator(IComparator<T> comparator) {
            this.comparator = comparator;
        }
        @Override
        public int compare(PGFTree<T>.PGFProxy data1, PGFTree<T>.PGFProxy data2) {
            return comparator.compare(data1.data, data2.data);
        }

        @Override
        public int compare(PGFTree<T>.PGFProxy data, IKey<PGFTree<T>.PGFProxy> key) {
            return comparator.compare(data.data, ((PGFKey<T>) key).key);
        }
    }
    
    public static <T> IComparator<PGFTree<T>.PGFProxy> comparator(IComparator<T> comparator) {
        return new PGFComparator<T>(comparator);
    }
    
    private static class PGFKey<T> implements IKey<PGFTree<T>.PGFProxy> {
        protected IKey<T> key = null;
        
        public PGFKey(IKey<T> key) {
            this.key = key;
        }

        @Override
        public boolean matches(PGFTree<T>.PGFProxy data) {
            return key.matches(data.data);
        }
    }
    
    public static <T> IKey<PGFTree<T>.PGFProxy> key(IKey<T> key) {
        return new PGFKey<T>(key);
    }
    
    public PGFTree(Tree<PGFProxy> tree) {
        this.tree = tree;
    }
    
    protected String treeToPGF(Tree.Node<PGFProxy> currentRoot, String tabs) {
        String pgfTree = "[missing]\n";
        
        if (currentRoot != null) {
            PGFProxy proxy = currentRoot.data;
            String subTreeFormat = proxy.subTreeFormat();
            String nodeFormat = proxy.nodeFormat();
            String childrenFormat = proxy.childrenFormat();
            String childFormat = proxy.childFormat();
            String edgeFromParentFormat = proxy.edgeFromParentFormat();
            
            String pgfLeftSubTree = treeToPGF(currentRoot.left, tabs + "    ");
            String pgfRightSubTree = treeToPGF(currentRoot.right, tabs + "    ");
            
            pgfTree = (childFormat != "" ? childFormat + " " : "") + "{\n" + (subTreeFormat != "" ? tabs + "    " + subTreeFormat + "\n" : "")
                            + tabs + "    node" + (nodeFormat != "" ? " " + nodeFormat : "") + " (" + currentRoot.data + ") {" + currentRoot.data + "}\n"
                            + (childrenFormat != "" ? tabs + "    " + childrenFormat + "\n" : "");
            
            if (!pgfLeftSubTree.equals("[missing]\n") || !pgfRightSubTree.equals("[missing]\n")) {
                pgfTree += tabs + "    child " + pgfLeftSubTree + "\n";
                pgfTree += tabs + "    child " + pgfRightSubTree + "\n";
            } 
            pgfTree += (edgeFromParentFormat != "" ? tabs + "    edge from parent " + edgeFromParentFormat + "\n" : "");
            pgfTree += tabs + "}"; //\n";
        }
        
        return pgfTree;
    }

    public String treeToPGF() {
        String pgfTree = treeToPGF(tree.root, "    ");
        pgfTree = pgfHeader 
                    + "    \\path " + pgfTree + ";\n"
                    + "\\end{tikzpicture}\n";
        return pgfTree;
    }
    
    public String toString() {
        return treeToPGF();
    }
    
    public PGFProxy pgfProxy(T data) {
        return new PGFProxy(data);
    }
}
