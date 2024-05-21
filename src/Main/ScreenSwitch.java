/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUI.BanHangJPanel;
import GUI.HangHoaJPanel;
import GUI.HoaDonJPanel;
import GUI.Admin.InfoDBJPanel;
import GUI.Admin.PermissionJPanel;
import GUI.Admin.PolicyJPanel;
import GUI.NhaCungCapJPanel;
import GUI.NhapHangJPanel;
import GUI.NhomHangHoaJPanel;
import GUI.Admin.SessionJPanel;
import GUI.Admin.TablespaceJPanel;
import GUI.Admin.UserJPanel;
import GUI.TrangChuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ScreenSwitch {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listItem = null;

    public ScreenSwitch(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem, String kindSelected) {
        this.kindSelected = kindSelected;

        jpnItem.setBackground(new Color(173, 216, 230));
        jlbItem.setBackground(new Color(173, 216, 230));

        root.removeAll();
        root.setLayout(new BorderLayout());
        if (this.kindSelected.equals("TrangChu")) {
            root.add(new TrangChuJPanel());
        } else {
            root.add(new InfoDBJPanel());
        }
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "BanHang":
                    node = new BanHangJPanel();
                    break;
                case "HangHoa":
                    node = new HangHoaJPanel();
                    break;
                case "NhomHangHoa":
                    node = new NhomHangHoaJPanel();
                    break;
                case "HoaDon":
                    node = new HoaDonJPanel();
                    break;
                case "NhapHang":
                    node = new NhapHangJPanel();
                    break;
                case "NhaCungCap":
                    node = new NhaCungCapJPanel();
                    break;
                case "InfoDB":
                    node = new InfoDBJPanel();
                    break;
                case "Session":
                    node = new SessionJPanel();
                    break;
                case "Tablespace":
                    node = new TablespaceJPanel();
                    break;
                case "User":
                    node = new UserJPanel();
                    break;
                case "Policy":
                    node = new PolicyJPanel();
                    break;
                case "Permission":
                    node = new PermissionJPanel();
                    break;
                default:
                    if (kindSelected.equals("TrangChu")) {
                        node = new TrangChuJPanel();
                    } else {
                        node = new InfoDBJPanel();
                    }
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent me) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(173, 216, 230));
            jlbItem.setBackground(new Color(173, 216, 230));
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            jpnItem.setBackground(new Color(173, 216, 230));
            jlbItem.setBackground(new Color(173, 216, 230));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(211, 211, 211));
                jlbItem.setBackground(new Color(211, 211, 211));
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(173, 216, 230));
                item.getJlb().setBackground(new Color(173, 216, 230));
            } else {
                item.getJpn().setBackground(new Color(211, 211, 211));
                item.getJlb().setBackground(new Color(211, 211, 211));
            }
        }
    }
}
