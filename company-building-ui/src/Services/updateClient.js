import axios from "axios";

const API_BASE_URL='http://localhost:8080/client';

export const updateClient = async (clientId, clientData) => {
    try {
      const response = await axios.patch(`${API_BASE_URL}/clients/${clientId}`, clientData);
      return response.data;
    } catch (error) {
      console.error('Error updating client:', error);
      throw error;
    }
  };
