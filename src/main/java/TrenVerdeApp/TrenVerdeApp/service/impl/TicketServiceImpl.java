package TrenVerdeApp.TrenVerdeApp.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TrenVerdeApp.TrenVerdeApp.entity.Ticket;
import TrenVerdeApp.TrenVerdeApp.repository.ITicketRepository;
import jakarta.transaction.Transactional;

@Service    
@Transactional
public class TicketServiceImpl implements ITicketService{
    
    @Autowired
    private ITicketRepository iTicketRepository;

    private List<Ticket> ticket = new ArrayList<>();

    @Override
    public List<Ticket> listarTicket() {
        return ticket = iTicketRepository.findAll();
    }

    @Override
    public Ticket guardarTicket(Ticket ticket){
        return iTicketRepository.save(ticket);
    }

    @Override
    public Ticket buscarTicketPorId(Long idRegistro) {
        Ticket ticket = iTicketRepository.findAllById(idTicket).orElse(null);
        return ticket; 
    }

    public Ticket eliminarTicket(Long idTicket) {
        iTicketRepository.deleteById(idTicket);
        return null;
    }

    public Ticket actualizarTicket(Long idTicket, Ticket ticketActualizado) {
        Ticket ticketExistente = iTicketRepository.findById(idTicket).erElse(null);

        if(ticketExistente != null) {
            ticketExistente.setOrigen(ticketActualizado.getOrigen());
            ticketExistente.setDestino(ticketActualizado.getDestino());
            ticketExistente.setClase(ticketActualizado.getClase());
            ticketExistente.setPrecio(ticketActualizado.getPrecio());
            ticketExistente.setEstado(ticketActualizado.getEstado());

        }else {
            return null;
        }
        return iTicketRepository.save(ticketExistente);
    }
}
