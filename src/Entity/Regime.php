<?php

namespace App\Entity;

use App\Repository\RegimeRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=RegimeRepository::class)
 */
class Regime
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="text")
     */
    private $Aliments_autorises;

    /**
     * @ORM\Column(type="text")
     */
    private $Aliments_interdits;

    /**
     * @ORM\Column(type="text")
     */
    private $petit_dejeuner;

    /**
     * @ORM\Column(type="text")
     */
    private $collation1;

    /**
     * @ORM\Column(type="text")
     */
    private $dejeuner;

    /**
     * @ORM\Column(type="text")
     */
    private $collation2;

    /**
     * @ORM\Column(type="text")
     */
    private $diner;

    /**
     * @ORM\Column(type="text")
     */
    private $conseils;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getAlimentsAutorises(): ?string
    {
        return $this->Aliments_autorises;
    }

    public function setAlimentsAutorises(string $Aliments_autorises): self
    {
        $this->Aliments_autorises = $Aliments_autorises;

        return $this;
    }

    public function getAlimentsInterdits(): ?string
    {
        return $this->Aliments_interdits;
    }

    public function setAlimentsInterdits(string $Aliments_interdits): self
    {
        $this->Aliments_interdits = $Aliments_interdits;

        return $this;
    }

    public function getPetitDejeuner(): ?string
    {
        return $this->petit_dejeuner;
    }

    public function setPetitDejeuner(string $petit_dejeuner): self
    {
        $this->petit_dejeuner = $petit_dejeuner;

        return $this;
    }

    public function getCollation1(): ?string
    {
        return $this->collation1;
    }

    public function setCollation1(string $collation1): self
    {
        $this->collation1 = $collation1;

        return $this;
    }

    public function getDejeuner(): ?string
    {
        return $this->dejeuner;
    }

    public function setDejeuner(string $dejeuner): self
    {
        $this->dejeuner = $dejeuner;

        return $this;
    }

    public function getCollation2(): ?string
    {
        return $this->collation2;
    }

    public function setCollation2(string $collation2): self
    {
        $this->collation2 = $collation2;

        return $this;
    }

    public function getDiner(): ?string
    {
        return $this->diner;
    }

    public function setDiner(string $diner): self
    {
        $this->diner = $diner;

        return $this;
    }

    public function getConseils(): ?string
    {
        return $this->conseils;
    }

    public function setConseils(string $conseils): self
    {
        $this->conseils = $conseils;

        return $this;
    }
}
