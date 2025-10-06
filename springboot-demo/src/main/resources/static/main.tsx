interface Item {
  id: number;
  name: string;
}

const ItemForm: React.FC = () => {
  const [name, setName] = React.useState('');

  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault();
    try {
            const itemToCreate: ItemForCreation = { name };
            const response = await fetch('/items', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(itemToCreate),
      });
      if (response.ok) {
        const newItem: Item = await response.json();
        console.log('Item added:', newItem);
        setName('');
      } else {
        console.error('Failed to add item');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <form style={{width:"300px"}} onSubmit={handleSubmit}>
      <input className="input"
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Enter item name"
        required
      />
	  <div className="button-group" style={{width:"350px"}, { marginTop:"3em"}} >
      <button style={{float:"right"}} className="button is-primary" type="submit">Add Item</button>
	  <a href="/" style={{float:"right"}} className="button is-secondary" type="submit">View Items</a>
    </div>
	</form>
  );
};

const App: React.FC = (props) => {
   return (
   <section style={{marginTop:"3em"}}className="container">
   <div className="hero">
   <div className="content">
   <h1>Typescript + React</h1>
    <p> Here is a starting point for our React and Typescript frontend as we build out Entity relationships </p>
   <hr/>
   <p>This input field will create a new <pre>Item</pre><br/> with the following attributes:</p>
   <p><pre>id: number; <br/>name: string;</pre></p>
   {props.children}
   </div>
   </div>
   </section>)
}


ReactDOM.render(<App><ItemForm /></App>, document.getElementById('root'));
