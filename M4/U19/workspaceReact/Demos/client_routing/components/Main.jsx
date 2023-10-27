import React from 'react';
import {Link} from 'react-router';

const Main = React.createClass({
	getInitialState: function() {
		let data = [
	      {id: "1",name: "Ricardo",email: "ricardo@banana.com"},
	      {id: "2",name: "Juan",email: "juan@banana.com"},
	      {id: "3",name: "Roberto",email: "roberto@banana.com"}
	    ];
		return {data: data};
	},

	handleUserSubmit: function(user) {
		var users = this.state.data;
		user.id = Date.now();
		var newUsers = users.concat([user]);
		this.setState({data: newUsers});

		console.log(user,newUsers);
	},
	render(){
		return (
			<div className="container">
				<h1>Usuarios</h1>
				<nav>
					<Link to="/">Usuarios</Link> | <Link to="/new">Nuevo</Link>
				</nav>
				{/*React.cloneElement(this.props.children, this.props)*/}
				{/*this.props.children*/}
				{
					React.cloneElement(
						this.props.children,
						{ data: this.state.data,onUserSubmit:this.handleUserSubmit}
					)
				}
			</div>
		)
	} 
})

export default Main;