import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import './index.css';
import './lib/css/styles.css';

class App extends Component {
  render() {
    return (
      <div className="App app">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to as</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
        <div>
        <div className="container">
            <div className="row">
                <div className="col-md-3">
                    
                    <ul className="app-feature-gallery app-feature-gallery-noshadow margin-bottom-0" style={{height: "132px"}}>
                        <li>
                            <div className="app-widget-tile">
                                <div className="line">
                                    <div className="title">Sales Per Month</div>
                                    <div className="title pull-right"><span className="label label-success label-ghost label-bordered">+14.2%</span></div>
                                </div>                                        
                                <div className="intval">9,427</div>                                        
                                <div className="line">
                                    <div className="subtitle">Total items sold</div>
                                    <div className="subtitle pull-right text-success"><span className="icon-arrow-up"></span> good</div>
                                </div>
                            </div>                                                                        
                        </li>
                        <li>
                            <div className="app-widget-tile">
                                <div className="line">
                                    <div className="title">Sales Per Year</div>
                                    <div className="title pull-right text-success">+32.9%</div>
                                </div>                                        
                                <div className="intval">24,834</div>
                                <div className="line">
                                    <div className="subtitle">Total items sold</div>
                                    <div className="subtitle pull-right text-success"><span className="icon-arrow-up"></span> good</div>
                                </div>
                            </div>                                                                        
                        </li>
                        <li>
                            <div className="app-widget-tile">
                                <div className="line">
                                    <div className="title">Profit</div>
                                    <div className="title pull-right text-success">+9.2%</div>
                                </div>                                        
                                <div className="intval">539,277 <small>usd</small></div>
                                <div className="line">
                                    <div className="subtitle">Frofit for the year</div>                                                
                                </div>
                            </div>                                                                        
                        </li>
                        <li>
                            <div className="app-widget-tile">
                                <div className="line">
                                    <div className="title">Outlay</div>
                                    <div className="title pull-right text-success">-12.7%</div>
                                </div>                                        
                                <div className="intval">45,385<small>usd</small></div>
                                <div className="line">
                                    <div className="subtitle">Statistic per year</div>                                                
                                </div>
                            </div>                                                                        
                        </li>
                    </ul>
                    
                </div>
                <div className="col-md-3">
                    
                    <ul className="app-feature-gallery app-feature-gallery-noshadow margin-bottom-0" style={{height: "152px"}}>
                        <li>
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="line">
                                    <div className="title">Visitors</div>
                                    <div className="title pull-right"><span className="label label-warning label-ghost label-bordered">-3.5%</span></div>
                                </div>                                        
                                <div className="intval">99,573</div>
                                <div className="line">
                                    <div className="subtitle">Visitors per month</div>
                                    <div className="subtitle pull-right text-warning"><span className="icon-arrow-down"></span> normal</div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="line">
                                    <div className="title">Returned</div>
                                    <div className="title pull-right text-success">67.1%</div>
                                </div>                                        
                                <div className="intval">61,488</div>
                                <div className="line">
                                    <div className="subtitle">Returned visitors per month</div>
                                    <div className="subtitle pull-right text-success"><span className="icon-arrow-up"></span></div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="line">
                                    <div className="title">New</div>
                                    <div className="title pull-right text-success">33.9%</div>
                                </div>                                        
                                <div className="intval">38,085</div>
                                <div className="line">
                                    <div className="subtitle">New visitors per month</div>                                                
                                    <div className="subtitle pull-right text-success"><span className="icon-arrow-up"></span></div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="line">
                                    <div className="title">Registred</div>
                                    <div className="title pull-right">+458</div>
                                </div>                                        
                                <div className="intval">12,554</div>
                                <div className="line">
                                    <div className="subtitle">Total registred users</div>                                                
                                </div>
                            </div>
                        </li>
                    </ul>
                                                    
                </div>
                <div className="col-md-3">
                    
                    <ul className="app-feature-gallery app-feature-gallery-noshadow margin-bottom-0" style={{height: "182px"}}>
                        <li>                                        
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <div className="icon icon-lg">
                                            <span className="icon-bubble"></span>
                                        </div>
                                    </div>
                                    <div className="col-sm-8">                                                    
                                        <div className="line">
                                            <div className="title">Messages</div>         
                                            <div className="title pull-right"><span className="label label-success label-ghost label-bordered">3 NEW</span></div>
                                        </div>                                        
                                        <div className="intval text-left">39 / 1,589</div>                                        
                                        <div className="line">
                                            <div className="subtitle"><a href="#">Open all messages</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>                                        
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <div className="icon icon-lg">
                                            <span className="icon-warning"></span>
                                        </div>
                                    </div>
                                    <div className="col-sm-8">                                                    
                                        <div className="line">
                                            <div className="title">Server Notifications</div>                                                        
                                        </div>                                        
                                        <div className="intval text-left">14 / 631</div>                                        
                                        <div className="line">
                                            <div className="subtitle"><a href="#">Open all notifications</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>                                        
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <div className="icon icon-lg">
                                            <span className="icon-envelope"></span>
                                        </div>
                                    </div>
                                    <div className="col-sm-8">                                                    
                                        <div className="line">
                                            <div className="title">Inbox Mail</div>                                                        
                                        </div>                                        
                                        <div className="intval text-left">2 / 481</div>                                        
                                        <div className="line">
                                            <div className="subtitle"><a href="#">Open inbox messages</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>                                        
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <div className="icon icon-lg">
                                            <span className="icon-users"></span>
                                        </div>
                                    </div>
                                    <div className="col-sm-8">                                                    
                                        <div className="line">
                                            <div className="title">Customers</div>             
                                            <div className="title pull-right"><span className="label label-danger label-bordered">15 NEW</span></div>
                                        </div>                                        
                                        <div className="intval text-left">6,233</div>                                        
                                        <div className="line">
                                            <div className="subtitle"><a href="#">Open contact list</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                    
                </div>
                <div className="col-md-3">
                    
                    <ul className="app-feature-gallery app-feature-gallery-noshadow margin-bottom-0" style={{height: "172px"}}>
                        <li>                                        
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <div className="icon icon-lg">
                                            <span className="icon-cloud-check"></span>
                                        </div>
                                    </div>
                                    <div className="col-sm-8">                                                    
                                        <div className="line">
                                            <div className="title">Total Server Load</div>
                                            <div className="subtitle pull-right text-success"><span className="fa fa-check"></span> UP</div>
                                        </div>                                        
                                        <div className="intval text-left">85.2%</div>                                        
                                        <div className="line">
                                            <div className="subtitle">Latest back up: <a href="#">12/07/2016</a></div>
                                        </div>
                                    </div>
                                </div>                                            
                            </div>
                        </li>
                        <li>                                        
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <div className="icon icon-lg">
                                            <span className="icon-database"></span>
                                        </div>
                                    </div>
                                    <div className="col-sm-8">                                                    
                                        <div className="line">
                                            <div className="title">Database Load</div>
                                            <div className="subtitle pull-right text-success"><span className="fa fa-check"></span> UP</div>
                                        </div>                                        
                                        <div className="intval text-left">43.16%</div>
                                        <div className="line">
                                            <div className="subtitle">4/10 databases used</div>
                                        </div>
                                    </div>
                                </div>                                            
                            </div>
                        </li>
                        <li>                                        
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <div className="icon icon-lg">
                                            <span className="icon-inbox text-danger"></span>
                                        </div>
                                    </div>
                                    <div className="col-sm-8">                                                    
                                        <div className="line">
                                            <div className="title">Disk Space</div>
                                            <div className="subtitle pull-right text-danger"><span className="fa fa-times"></span> Critical</div>
                                        </div>                                        
                                        <div className="intval text-left">99.98%</div>
                                        <div className="line">
                                            <div className="subtitle">234.2GB / 240GB used</div>
                                        </div>
                                    </div>
                                </div>                                            
                            </div>
                        </li>
                        <li>                                        
                            <div className="app-widget-tile app-widget-highlight">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <div className="icon icon-lg">
                                            <span className="icon-heart-pulse"></span>
                                        </div>
                                    </div>
                                    <div className="col-sm-8">                                                    
                                        <div className="line">
                                            <div className="title">Proccessor</div>
                                            <div className="subtitle pull-right text-success"><span className="fa fa-check"></span> Normal</div>
                                        </div>                                        
                                        <div className="intval text-left">32.5%</div>
                                        <div className="line">
                                            <div className="subtitle">Intule Cori P7, 3.6Ghz</div>
                                        </div>
                                    </div>
                                </div>                                            
                            </div>
                        </li>
                    </ul>
                    
                </div>
            </div>
        </div>
          </div>
      </div>
    );
  }
}

export default App;
