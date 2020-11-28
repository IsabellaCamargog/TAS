package br.edu.materdei.tas.desktop.gui.menuabas;

import br.edu.materdei.tas.desktop.MainFrame;
import br.edu.materdei.tas.desktop.bean.ItemMenuBean;
import br.edu.materdei.tas.desktop.gui.core.TasImagePanel;
import java.util.List;
import javax.swing.ImageIcon;
import br.edu.materdei.tas.desktop.view.GenericView;


public class TasMenuAba extends TasImagePanel {
    private MainFrame mainframe;

    /**
     * Creates new form TasMenuAba
     */
    public TasMenuAba() {
        initComponents();        
        
        this.setImage(new ImageIcon(getClass().getResource("/assets/system/menuabas/bgAbas.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void setAbas(MainFrame frame, List<ItemMenuBean> abas) {
        mainframe = frame;
        boolean first = true;
        
        for (final ItemMenuBean item : abas) {
            TasItemMenuAba menu = new TasItemMenuAba();            
            menu.setTituloAba(item.getNomeAba().toUpperCase());
            
            if (first) {
                menu.setSelecionado(first);
                
                //Carrega primeira aba
                GenericView view = (GenericView) item.getView();                    
                mainframe.setContent(item.getView());
                view.setMainFrame(mainframe);
                view.preinit();
                
                first = false;
            }
            
            menu.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    //Barra Ferramentas
                    mainframe.setStatus("Carregando dados....");
                    GenericView view = (GenericView) item.getView();                    
                    mainframe.setContent(item.getView());
                    view.setMainFrame(mainframe);
                    view.preinit();
                }
            });
            
            this.add(menu);
        }
    }   
}