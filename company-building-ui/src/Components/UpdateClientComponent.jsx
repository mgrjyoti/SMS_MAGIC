import React, { useState } from 'react';
import axios from 'axios';

const UpdateClientComponent = () => {
  const [clientId, setClientId] = useState('');
  const [fieldName, setFieldName] = useState('');
  const [fieldValue, setFieldValue] = useState('');

  const handleUpdateClientField = async () => {
    try {
      const response = await axios.patch(`/api/clients/${clientId}`, {
        [fieldName]: fieldValue
      });
      console.log('Updated client:', response.data);
    } catch (error) {
      console.error('Error updating client field:', error);
    }
  };

  return (
    <div className='container'>
      <input type="text" placeholder="Client ID" value={clientId} onChange={(e) => setClientId(e.target.value)} />
      <br /><br />
      <input type="text" placeholder="Field Name" value={fieldName} onChange={(e) => setFieldName(e.target.value)} />
      <br /><br />
      <input type="text" placeholder="Field Value" value={fieldValue} onChange={(e) => setFieldValue(e.target.value)} />
      <br /><br />
      <button onClick={handleUpdateClientField}>Update Client Field</button>
    </div>
  );
};

export default UpdateClientComponent;
