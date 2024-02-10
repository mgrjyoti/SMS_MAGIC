import React, { useState } from 'react';
import axios from 'axios';

const CreateClientComponent = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [companyId, setCompanyId] = useState('');

  const handleCreateClient = async () => {
    try {
      const response = await axios.post('/api/clients', {
        name,
        email,
        phone,
        companyId
      });
      console.log('Created client:', response.data);
    } catch (error) {
      console.error('Error creating client:', error);
    }
  };

  return (
    <div className='container'>
      <input type="text" placeholder="Name" value={name} onChange={(e) => setName(e.target.value)} />
      <br /><br />
      <input type="text" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
      <br /><br />
      <input type="text" placeholder="Phone" value={phone} onChange={(e) => setPhone(e.target.value)} />
      <br /><br />
      <input type="text" placeholder="Company ID" value={companyId} onChange={(e) => setCompanyId(e.target.value)} />
      <br /><br />
      <button onClick={handleCreateClient}>Create Client</button>
    </div>
  );
};

export default CreateClientComponent;
