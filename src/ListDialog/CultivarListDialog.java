/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CultivarListDialog.java
 *
 * Created on Mar 16, 2010, 10:02:02 PM
 */

package ListDialog;

import DSSATModel.Crop;
import DSSATModel.CropList;
import FileXModel.FileX;
import DSSATModel.CultivarList;
import DSSATModel.ExperimentType;
import Extensions.Utils;
import FileXModel.Cultivar;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import xbuild.Components.XColumn;

/**
 *
 * @author Jazzy
 */
public class CultivarListDialog extends javax.swing.JDialog {

    /** Creates new form CultivarListDialog */

    private ArrayList<DSSATModel.Cultivar> cultivars;

    public CultivarListDialog(java.awt.Frame parent, Cultivar cul, boolean modal) {
        super(parent, modal);
        initComponents();
        
        AddDataToTable(cul);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        Dimension winSize = getSize();
        setLocation((screenWidth - winSize.width) / 2 , (screenHeight - winSize.height) / 2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bnOK = new javax.swing.JButton();
        bnCancel = new javax.swing.JButton();
        cbCultivar = new xbuild.Components.XDropdownTableComboBox();
        cbCrop = new xbuild.Components.XDropdownTableComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bnOK.setText("OK");
        bnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnOKActionPerformed(evt);
            }
        });

        bnCancel.setText("Cancel");
        bnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnCancelActionPerformed(evt);
            }
        });

        cbCultivar.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCultivarPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbCrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCropActionPerformed(evt);
            }
        });

        jLabel1.setText("Crop");

        jLabel2.setText("Cultivars");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 219, Short.MAX_VALUE)
                        .addComponent(bnOK)
                        .addGap(26, 26, 26)
                        .addComponent(bnCancel))
                    .addComponent(cbCultivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCrop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(cbCrop, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCultivar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnOK)
                    .addComponent(bnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnOKActionPerformed
        cultivars = new ArrayList<>();
        
        DSSATModel.Cultivar c = (DSSATModel.Cultivar)cbCultivar.getSelectedItem();
        cultivars.add(c);
        
        dispose();
    }//GEN-LAST:event_bnOKActionPerformed

    private void bnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnCancelActionPerformed
        SetNull();
        dispose();
    }//GEN-LAST:event_bnCancelActionPerformed

    private void cbCultivarPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCultivarPopupMenuWillBecomeInvisible
        if(FileX.general.FileType == ExperimentType.Experimental){
            EventQueue.invokeLater(() -> {            
                Utils.setTimeout(() -> {
                    cbCultivar.showPopup();
                }, 1);
            });
        }
    }//GEN-LAST:event_cbCultivarPopupMenuWillBecomeInvisible

    private void cbCropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCropActionPerformed
        Crop crop = (Crop) cbCrop.getSelectedItem();
        if(crop != null){
            cbCultivar.setInit(null, "CulCode", "", CultivarList.GetAt(crop), new XColumn[]{ new XColumn("CulName", "Cultivar Name", 200)}, "CropCode", 430);
        }
    }//GEN-LAST:event_cbCropActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnCancel;
    private javax.swing.JButton bnOK;
    private xbuild.Components.XDropdownTableComboBox cbCrop;
    private xbuild.Components.XDropdownTableComboBox cbCultivar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    public ArrayList<DSSATModel.Cultivar> GetData() {
        return cultivars;
    }

    public void SetNull()
    {
        cultivars = null;
    }

    private void AddDataToTable(Cultivar cul) {       
        if(FileX.general.FileType == ExperimentType.Experimental){
            cbCrop.setVisible(false);
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            cbCultivar.setInit(null, "CulCode", cul != null ? cul.CR : "", CultivarList.GetAt(FileX.general.crop), new XColumn[]{new XColumn("CulName", "Cultivar Name", 200)}, "CropCode");
            this.setPreferredSize(new Dimension(this.getPreferredSize().width, 590));
            
            EventQueue.invokeLater(() -> {
            Utils.setTimeout(() -> {
                cbCultivar.showPopup();
            }, 50);
        });
        }
        else{
            cbCrop.setVisible(true);
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            cbCrop.setInit(null, "CropCode", cul != null ? cul.CR : "", CropList.GetAll(), new XColumn[] { new  XColumn("CropName", "Crop Name", 200)}, "CropCode");
            
            ArrayList<DSSATModel.Cultivar> culList = new ArrayList<>();
            if(cul != null){
                DSSATModel.Crop crop = new DSSATModel.Crop();
                crop.CropCode = cul.CR;
                culList = (ArrayList<DSSATModel.Cultivar>) CultivarList.GetAt(crop);
            }
                    
            cbCultivar.setInit(null, "INGENO", cul != null ? cul.INGENO : "", culList, new XColumn[]{ new XColumn("CulName", "Cultivar Name", 200)}, "CulCode");
            
            resize(new Dimension(this.getPreferredSize().width, 200));
        }
    }
}
