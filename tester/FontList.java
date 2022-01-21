  String FontList[];
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        FontList = ge.getAvailableFontFamilyNames();
        
        for(int i = 0; i < 235; i++) {
        	System.out.println(FontList[i]);
        }
