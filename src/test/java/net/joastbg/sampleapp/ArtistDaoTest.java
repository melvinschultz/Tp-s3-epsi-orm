package net.joastbg.sampleapp;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ArtistDao;
import net.joastbg.sampleapp.entities.Artist;
import net.joastbg.sampleapp.exceptions.DaoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ArtistDaoTest {

    @Autowired
    ArtistDao artistDAO;

    @Before
    public void setUp() {

    }

    @Test
    public void testFindAll(){
        List<Artist> artists = artistDAO.findAll();
        Assert.assertNotNull(artists);
        for(Artist artist: artists){
            System.out.println("ArtistDaoTest TestFindAll NAME --> "+artist.getName());
        }
    }

    @Test
    public void testFindByName() throws DaoException {
        String name = "Muse";
        Artist artist = artistDAO.findByName(name);
        Assert.assertNotNull(artist);
        System.out.println("ArtistDaoTest TestFindByName NAME --> "+artist.getName());
        System.out.println("ArtistDaoTest TestFindByName ID --> "+artist.getId());

    }

    @Test public void testFindArtworkByArtistName(){

    }
}