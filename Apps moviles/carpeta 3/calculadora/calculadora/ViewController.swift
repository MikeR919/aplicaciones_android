//
//  ViewController.swift
//  calculadora
//
//  Created by Alumno IDS on 2/24/20.
//  Copyright © 2020 Alumno IDS. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    var numberOnScreen:Double=0
    var num: Double = 0
    var calculos = false
    var operador = 0
    var cadena=""
    
    
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var hist: UILabel!
    
    @IBAction func numbers(_ sender: UIButton) {
        if calculos == true{
            label.text = String(sender.tag-1)
            numberOnScreen = Double(label.text!)!
            calculos = false
        }
        else{
            label.text=label.text! + String(sender.tag-1)
            numberOnScreen = Double(label.text!)!
        }
        
        
    }
    
    
    @IBAction func buttons(_ sender: UIButton) {
        if label.text != "" && sender.tag != 11 && sender.tag != 16{
            
            num = Double(label.text!)!
            
            if sender.tag==12{ //divide
                label.text = "/"
                
            }
            else if (sender.tag == 13){ //mult
                label.text = "x"
                
            }
            else if (sender.tag == 14){ //resta
                label.text = "-"
                
            }
            else if (sender.tag == 15){//suma
                label.text = "+"
                
            }
            else if (sender.tag == 17){//suma
                label.text = "%"
                
            }
            
            
            operador=sender.tag
            calculos=true
        }
        
        else if sender.tag == 16 {
            if operador == 12{
                label.text = String(num / numberOnScreen)
                cadena = String (num / numberOnScreen)
                hist.text=hist.text! + String("="+cadena+" ")
            }
             else if operador == 13{
                label.text = String(num * numberOnScreen)
                cadena = String (num * numberOnScreen)
                hist.text=hist.text! + String("="+cadena+" ")
            }
            else if operador == 14{
                label.text = String(num - numberOnScreen)
                cadena = String (num - numberOnScreen)
                hist.text=hist.text! + String("="+cadena+" ")
            }
            else if operador == 15{
                label.text = String(num + numberOnScreen)
                cadena = String (num + numberOnScreen)
                hist.text=hist.text! + String("="+cadena+" ")
            }
            else if operador == 17{
                label.text = String(num * (numberOnScreen*0.01))
                cadena = String (num * numberOnScreen)
                hist.text=hist.text! + String("="+cadena+" ")
            }
            
            
        }
        else if sender.tag == 11{
            label.text = ""
            num = 0
            numberOnScreen = 0
            operador = 0
        }
    }
    
    
    
    @IBAction func historial(_ sender: UIButton) {
        
        if sender.tag==12{ //divide
            hist.text=hist.text! + String("/")
            
        }
        else if (sender.tag == 13){ //mult
           hist.text=hist.text! + String("x")
            
        }
        else if (sender.tag == 14){ //resta
            hist.text=hist.text! + String("-")
            
        }
        else if (sender.tag == 15){//suma
            hist.text=hist.text! + String("+")
            
        }
        else if (sender.tag == 17){//suma
            hist.text=hist.text! + String("%")
            
        }
            
        else{
            hist.text=hist.text! + String(sender.tag-1)
        }
    }
    
    
    @IBOutlet weak var a: UIButton!
    @IBOutlet weak var b: UIButton!
    @IBOutlet weak var c: UIButton!
    @IBOutlet weak var d: UIButton!
    @IBOutlet weak var e: UIButton!
    @IBOutlet weak var f: UIButton!
    @IBOutlet weak var g: UIButton!
    @IBOutlet weak var h: UIButton!
    @IBOutlet weak var i: UIButton!
    @IBOutlet weak var j: UIButton!
    @IBOutlet weak var k: UIButton!
    @IBOutlet weak var l: UIButton!
    @IBOutlet weak var m: UIButton!
    @IBOutlet weak var n: UIButton!
    @IBOutlet weak var o: UIButton!
    @IBOutlet weak var p: UIButton!
    @IBOutlet weak var q: UIButton!
    
    
    
    
    
    
    
    @IBOutlet weak var lbl: UILabel!
    
    @IBAction func slider(_ sender: UISlider) {
        lbl.text = String(Int (sender.value))
        let colnum = Int (sender.value)
        
        switch colnum {
        case 1:
            self.view.backgroundColor=UIColor.blue
            a.tintColor=UIColor.red
            b.tintColor=UIColor.red
            c.tintColor=UIColor.red
            d.tintColor=UIColor.red
            e.tintColor=UIColor.red
            f.tintColor=UIColor.red
            g.tintColor=UIColor.red
            h.tintColor=UIColor.red
            i.tintColor=UIColor.red
            j.tintColor=UIColor.red
            k.tintColor=UIColor.red
            l.tintColor=UIColor.red
            m.tintColor=UIColor.red
            n.tintColor=UIColor.red
            o.tintColor=UIColor.red
            p.tintColor=UIColor.red
            q.tintColor=UIColor.red
            break
        case 2:
            self.view.backgroundColor=UIColor.brown
            a.tintColor=UIColor.blue
            b.tintColor=UIColor.blue
            c.tintColor=UIColor.blue
            d.tintColor=UIColor.blue
            e.tintColor=UIColor.blue
            f.tintColor=UIColor.blue
            g.tintColor=UIColor.blue
            h.tintColor=UIColor.blue
            i.tintColor=UIColor.blue
            j.tintColor=UIColor.blue
            k.tintColor=UIColor.blue
            l.tintColor=UIColor.blue
            m.tintColor=UIColor.blue
            n.tintColor=UIColor.blue
            o.tintColor=UIColor.blue
            p.tintColor=UIColor.blue
            q.tintColor=UIColor.blue
            break
        case 3:
            self.view.backgroundColor=UIColor.red
            a.tintColor=UIColor.brown
            b.tintColor=UIColor.brown
            c.tintColor=UIColor.brown
            d.tintColor=UIColor.brown
            e.tintColor=UIColor.brown
            f.tintColor=UIColor.brown
            g.tintColor=UIColor.brown
            h.tintColor=UIColor.brown
            i.tintColor=UIColor.brown
            j.tintColor=UIColor.brown
            k.tintColor=UIColor.brown
            l.tintColor=UIColor.brown
            m.tintColor=UIColor.brown
            n.tintColor=UIColor.brown
            o.tintColor=UIColor.brown
            p.tintColor=UIColor.brown
            q.tintColor=UIColor.brown
            break
        case 4:
            self.view.backgroundColor=UIColor.orange
            a.tintColor=UIColor.purple
            b.tintColor=UIColor.purple
            c.tintColor=UIColor.purple
            d.tintColor=UIColor.purple
            e.tintColor=UIColor.purple
            f.tintColor=UIColor.purple
            g.tintColor=UIColor.purple
            h.tintColor=UIColor.purple
            i.tintColor=UIColor.purple
            j.tintColor=UIColor.purple
            k.tintColor=UIColor.purple
            l.tintColor=UIColor.purple
            m.tintColor=UIColor.purple
            n.tintColor=UIColor.purple
            o.tintColor=UIColor.purple
            p.tintColor=UIColor.purple
            q.tintColor=UIColor.purple
            break
        case 5:
            self.view.backgroundColor=UIColor.purple
            a.tintColor=UIColor.red
            b.tintColor=UIColor.red
            c.tintColor=UIColor.red
            d.tintColor=UIColor.red
            e.tintColor=UIColor.red
            f.tintColor=UIColor.red
            g.tintColor=UIColor.red
            h.tintColor=UIColor.red
            i.tintColor=UIColor.red
            j.tintColor=UIColor.red
            k.tintColor=UIColor.red
            l.tintColor=UIColor.red
            m.tintColor=UIColor.red
            n.tintColor=UIColor.red
            o.tintColor=UIColor.red
            p.tintColor=UIColor.red
            q.tintColor=UIColor.red
            break
        default:self.view.backgroundColor=UIColor.green
        }
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    



}

