package org.system.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.shoppingcart.model.Line;
import org.system.shoppingcart.repository.LineRepository;

import javax.transaction.Transactional;

/**
 * LineService Implementation
 *
 * Bugs: none known
 *
 * @author       Shiraz Shrestha (987052) - Team II APR2020
 * @version      1.0
 *
 */

@Service
@Transactional
public class LineServiceImpl implements LineService {

    @Autowired
    LineRepository lineRepository;

    @Override
    public Line getLineById(Long id) {
        System.out.println("*************** line id = " + id);
        return lineRepository.findById(id).get();
    }

    @Override
    public void updateQuantity(int quantity, Long lineId) {
        Line line = this.lineRepository.findById(lineId).get();
        line.setQuantity(quantity);
        lineRepository.save(line);
    }
}
